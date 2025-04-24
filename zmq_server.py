
import zmq
import time
import sys
import ccxt.pro as ccxt
import asyncio
import zmq
import zmq.asyncio
import pickle

ctx = zmq.asyncio.Context()
socket = ctx.socket(zmq.PUB)
socket.bind("tcp://*:5555")
proxies = {
    'proxies': {
        'http': '127.0.0.1:7890',
        'https': '127.0.0.1:7890',
    }
}

exchanges = {
    "bnc": ccxt.binance,
    "bybt": ccxt.bybit
}

async def feed_orderbook(exch:str):
    exchange:ccxt.Exchange = exchanges[exch]()
    # exchange.httpProxy = "http://127.0.0.1:7890/"
    # exchange.wsProxy = "http://127.0.0.1:7890/"
    symbol = "BTC/USDT"
    print(f"starting receiving order from {exchange.id} for symbol {symbol}")
    while True:
        try:
            orderbook = await exchange.watch_order_book(symbol=symbol)
            print(f"received orderbook from {exch}: {orderbook}")
            await socket.send_multipart([exch.encode(), pickle.dumps(orderbook)])
        except Exception as e:
            print(e)
            sys.exit(1)
        finally:
            await exchange.close()

async def main():
    exchanges = ["bnc","bybt"]
    coroutines = [feed_orderbook(exchange_id) for exchange_id in exchanges]
    return await asyncio.gather(*coroutines)


if __name__ == "__main__":
    asyncio.run(main())