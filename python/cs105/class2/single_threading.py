import httplib
import datetime

def get_data():
    conn = httplib.HTTPSConnection('jsonplaceholder.typicode.com')
    conn.request('GET', '/posts/1')
    resp = conn.getresponse()
    resp.read()

start = datetime.datetime.now()
for i in range(100):
    get_data()
end = datetime.datetime.now()
print(end-start)

