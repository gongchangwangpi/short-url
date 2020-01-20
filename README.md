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
