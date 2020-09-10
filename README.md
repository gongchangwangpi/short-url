# short-url
convert a long url to short, and redirect.

# generate a short url for long url
## URL
`GET {host}:{port}/api/short?longUrl=yourUrl -H 'appKey=yourAppKey'`
## Response
```json
{
  "code": 200,
  "msg": "OK",
  "body": "http://demo.shorturl.com/s/shorturl"
}
```
You can use the body's url for redirect to your original long url.


# Install
It use `mysql` and `redis`, please use `resources\short_url.sql` to init mysql database.  

# Performance Report
Use MacBook Pro 2014, i5 CPU 8G Memory, startup 3 short-url instance with default JVM args.
The Tests set 64 threads runs 50000 counts of HTTP client.
The total cost millis seconds are : 289877, 249930, 211518, 249299, 239525.
