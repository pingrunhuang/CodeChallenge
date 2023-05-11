import numpy as np
import pandas as pd
import random
import datetime as dt
import time
from typing import Callable


def millisecond_timer(func: Callable):

    def inner(*args):
        stime = time.time_ns()
        res = func(*args)
        etime = time.time_ns()
        print(f"{func.__name__} time used: {(etime-stime)/1000}ms")
        return res
    return inner


def date_generator(sdt, edt):
    while sdt <= edt:
        yield sdt
        sdt += dt.timedelta(days=1)


def random_data_generator():
    sdt = dt.datetime.fromisoformat("2023-01-01")
    edt = dt.datetime.fromisoformat("2023-05-01")
    dates = [x for x in date_generator(sdt, edt)]
    data1 = [
        {
            "date": x, 
            "symbol": "a", 
            "price": random.uniform(200, 500),
            "volume": random.uniform(1000, 2000),
            "spread": random.uniform(0, 1)
        } for x in dates
    ]
    data2 = [
        {
            "date": x,
            "symbol": "b", 
            "price": random.uniform(600, 1000),
            "volume": random.uniform(2000, 3000),
            "spread": random.uniform(0, 1)
        } for x in dates
    ]
    data3 = [
        {
            "date": x,
            "symbol": "c", 
            "price": random.uniform(1000, 2000),
            "volume": random.uniform(3000, 4000),
            "spread": random.uniform(0, 1)
        } for x in dates
    ]
    data = data1 + data2 + data3
    return pd.DataFrame(data)


df = random_data_generator()

"""
vectorization with np.where
"""
@millisecond_timer
def test_vectorization_npwhere():
    np.where((df["price"]/df["volume"])>df["spread"], "buy", "sell")

test_vectorization_npwhere()

"""
vectorize with np.vectorize 
"""
@millisecond_timer
def test_np_vec(df):
    def set_buysell(price, volume, spread):
        if price/volume>spread:
            return "buy"
        else:
            return "sell"
    vec_func = np.vectorize(
        set_buysell 
    )
    vec_func(df["price"], df["volume"], df["spread"])

test_np_vec(df)

"""
simple apply function
"""
@millisecond_timer
def test_apply():
    df.apply(
        lambda x: "buy" if x["price"]/x["volume"]>x["spread"] else "sell", axis=1
    )

test_apply()


"""
handle multi condition with np.select 
"""
@millisecond_timer
def test_multicondition1(df):
    conditions = [
        df["date"].dt.weekday == 1,
        df["date"].dt.weekday == 2,
        df["date"].dt.weekday == 3,
        df["date"].dt.weekday == 4,
        df["date"].dt.weekday == 5,
        df["date"].dt.weekday == 6,
        df["date"].dt.weekday == 7
    ]
    choises = [
        "monday",
        "tuesday",
        "wednesday",
        "thursday",
        "friday",
        "saturday",
        "sunday"
    ]
    np.select(conditions, choises, default="NA")

test_multicondition1(df)

@millisecond_timer
def test_multicondition2(df):
    df["weekofday"] = df["date"].map(lambda x: x.weekday())
    conditions = [
        df["weekofday"] == 1,
        df["weekofday"] == 2,
        df["weekofday"] == 3,
        df["weekofday"] == 4,
        df["weekofday"] == 5,
        df["weekofday"] == 6,
        df["weekofday"] == 7
    ]
    choises = [
        "monday",
        "tuesday",
        "wednesday",
        "thursday",
        "friday",
        "saturday",
        "sunday"
    ]
    np.select(conditions, choises, default="NA")
test_multicondition2(df)

"""
handle dict look up with vectorization
"""
