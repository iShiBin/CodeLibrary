import httplib
import threading
import time

def worker(num):
    for i in range(num):
        time.sleep(1)
        conn = httplib.HTTPSConnection('jsonplaceholder.typicode.com')
        conn.request('GET', '/posts/1')
        resp = conn.getresponse()
        resp.read()

threads = []
for i in range(5):
    t = threading.Thread(target=worker, args=(20, ))
    threads.append(t)
    t.start()
