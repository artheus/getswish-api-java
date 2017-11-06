# Currently Work-in-Progress
**Warning!** Do not use this for any production environments!
This is a Work-in-progress project which is not currently well tested.

There comes no warranty with this library whatsoever.

This project is Licenced with The Unlicense http://unlicense.org/

Please read the [LICENSE](./LICENSE) or refer to the link in the row above for more information about the license

# Important! Certificates for testing

For being able to run the tests, you currently need to have the certificates for testing.
You can get these by registering at getswish.se as a merchant developer.
I will not provide these!

When You have downloaded the certificates, you must specify their filesystem path and passwords in the
environment variables:
* SWISH_KEYSTORE_FILE
* SWISH_KEYSTORE_PWD
* SWISH_TRUSTSTORE_FILE
* SWISH_TRUSTSTORE_PWD

For creating the truststore you will need to use the `keytool` tool, or alternatively `openssl`

```
keytool -import -file /path/to/swish/root-ca.pem -alias firstCA -keystore myTrustStoreFileName
```

I used this Oracle documentation for creating mine.
https://docs.oracle.com/cd/E19509-01/820-3503/6nf1il6er/index.html
