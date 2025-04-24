import zmq
import pickle
import sys
import zmq.asyncio
import asyncio
from datetime import datetime
import traceback

ctx = zmq.asyncio.Context()

bnc_orderbook = None
bybt_orderbook = None


def largest_bb_diff():
    global bnc_orderbook
    global bybt_orderbook
    result = bnc_orderbook["bids"][0][0] - bybt_orderbook["bids"][0][0]
    bnc_orderbook=None
    bybt_orderbook=None
    return result

price_func_registory = {
    "largest_bb_diff": [largest_bb_diff, None, datetime.now()]
}


async def receive():
    print("receiving msg")
    socket = ctx.socket(zmq.SUB)
    socket.connect("tcp://localhost:5555")
    socket.setsockopt_string(zmq.SUBSCRIBE, 'bnc')
    socket.setsockopt_string(zmq.SUBSCRIBE, 'bybt')
    decay = 10
    funcname = "largest_bb_diff"
    global bnc_orderbook
    global bybt_orderbook
    try:
        while True:
            topic, msg = await socket.recv_multipart()
            print(topic.decode())
            
            if topic.decode()=="bybt" and not bybt_orderbook:
                bybt_orderbook = pickle.loads(msg)
                # print(bybt_orderbook)

            elif topic.decode()=="bnc" and not bnc_orderbook:
                bnc_orderbook = pickle.loads(msg)
                # print(bnc_orderbook)
            
            if (bnc_orderbook and bybt_orderbook) and \
                (datetime.now()-price_func_registory[funcname][2]).seconds>decay:
                res = price_func_registory[funcname][0]()
                if price_func_registory[funcname][1] and price_func_registory[funcname][1]<res:
                    price_func_registory[funcname][1] = res
                    price_func_registory[funcname][2] = datetime.now()
                    print(price_func_registory[funcname])
            
    except Exception as e:
        print(e)
        traceback.print_exc()
        sys.exit()

if __name__ == "__main__":
    asyncio.run(receive())

