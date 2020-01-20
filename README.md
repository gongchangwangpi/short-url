# short-url
generate short url, and redirect.

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
The total cost time below:  
|-use time-|-total req-| 
| ----- | ----- |  
| 289877| 50000 | 
| 249930| 50000 | 
| 211518| 50000 | 
| 249299| 50000 | 
| 239525| 50000 | 
