# Bugs
## 1. Pay with SWIFT, bank country code is US, without aba, request is still successful.
> Severity : High<br />
>
> Test case : SWIFT_in_US_missing_aba<br />
>
> Request : 
```json
{
      "payment_method": "SWIFT",
      "bank_country_code": "US",
      "account_name": "John Lulu",
      "account_number": "123",
      "swift_code": "ICBCUSBJ",
      "aba": ""
}
```
> Expected response : 

```json
{
      "error":"'aba' is required when bank country code is 'US'"
}
```

> Actual response :

```json
{
      "success":"Bank details saved"
}
```

## 2. Pay with SWIFT, bank country code is US, the length of  account number is longer than 17, but the response content is not expected.  

> Severity : Medium<br />
>
> Test case : SWIFT_in_US_longer_account_number <br />
>
> Request : 

```json
{
      "payment_method": "SWIFT",
      "bank_country_code": "US",
      "account_name": "John Lulu",
      "account_number": "123456789012345678",
      "swift_code": "ICBCUSBJ",
      "aba": "112233445"
}
```

> Expected response : 

```json
{
      "error":"Length of account_number should be between 1 and 17"
}
```

> Actual response :

```json
{
      "error":"Length of account_number should be between 7 and 11 when bank_country_code is 'US'"
}
```

## 3. Pay with SWIFT, bank country code is AU, the length of  account number is longer than 9, but the response content is not expected.

> Severity : Medium<br />
>
> Test case : SWIFT_in_AU_longer_account_number <br />
>
> Request : 

```json
{
      "payment_method": "SWIFT",
      "bank_country_code": "AU",
      "account_name": "John Lulu",
      "account_number": "1234567890",
      "swift_code": "ICBCAUBJ",
      "bsb": "112233"
}
```

> Expected response : 

```json
{
      "error":"Length of account_number should be between 6 and 9"
}
```

> Actual response :

```json
{
      "error":"Length of account_number should be between 7 and 11 when bank_country_code is 'US'"
}
```

## 4. Pay with SWIFT, bank country code is AU, the length of  account number is shorter than 6, but the response content is not expected.

> Severity : Medium<br />
>
> Test case : SWIFT_in_AU_shorter_account_number <br />
>
> Request : 

```json
{
      "payment_method": "SWIFT",
      "bank_country_code": "AU",
      "account_name": "John Lulu",
      "account_number": "12345",
      "swift_code": "ICBCAUBJ",
      "bsb": "112233"
}
```

> Expected response : 

```json
{
      "error":"Length of account_number should be between 6 and 9"
}
```

> Actual response :

```json
{
      "error":"Length of account_number should be between 7 and 11 when bank_country_code is 'US'"
}
```

## 5. Pay with SWIFT, bank country code is CN, the length of  account number is 20, but the response is error.

> Severity : High<br />
>
> Test case : SWIFT_in_CN_long_account_number  <br />
>
> Request : 

```json
{
  "payment_method": "SWIFT",
  "bank_country_code": "CN",
  "account_name": "John Lulu",
  "account_number": "12345678901234567890",
  "swift_code": "ICBCCNBJ"
}
```

> Expected response : 

```json
{
  "success":"Bank details saved"
}
```

> Actual response :

```json
{
  "error":"Length of account_number should be between 7 and 11 when bank_country_code is 'US'"
}
```

## 6. Pay with SWIFT, bank country code is CN, the length of  account number is shorter than 8, but the response is not expected.

> Severity : High<br />
>
> Test case : SWIFT_in_CN_shorter_account_number  <br />
>
> Request : 

```json
{
  "payment_method": "SWIFT",
  "bank_country_code": "CN",
  "account_name": "John Lulu",
  "account_number": "1234567",
  "swift_code": "ICBCCNBJ"
}
```

> Expected response : 

```json
{
  "error":"Length of account_number should be between 8 and 20"
}
```

> Actual response :

```json
{
  "success":"Bank details saved"
}
```

## 7. Pay with SWIFT, bank country code is CN, the length of  account number is longer than 20, but the response content is not expected.

> Severity : Medium<br />
>
> Test case : SWIFT_in_CN_longer_account_number  <br />
>
> Request : 

```json
{
  "payment_method": "SWIFT",
  "bank_country_code": "CN",
  "account_name": "John Lulu",
  "account_number": "123456789012345678901",
  "swift_code": "ICBCCNBJ"
}
```

> Expected response : 

```json
{
  "error":"Length of account_number should be between 8 and 20"
}
```

> Actual response :

```json
{
  "error":"Length of account_number should be between 7 and 11 when bank_country_code is 'US'"
}
```

## 