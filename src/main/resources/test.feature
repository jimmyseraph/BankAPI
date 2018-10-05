Feature: Bank Api Test
  Background:
    Given Create http request with url http://preview.airwallex.com:30001/bank
  Scenario Outline: SWIFT_in_US_<case_suffix>
    When Request method is POST
    And Set content type is json, body is
    """
    {
      "payment_method": "<payment_method>",
      "bank_country_code": "<bank_country_code>",
      "account_name": "<account_name>",
      "account_number": "<account_number>",
      "swift_code": "<swift_code>",
      "aba": "<aba>"
    }
    """
    And Send the request
    Then Assert the code is <request_code>
    Then Assert body is <entity_name> with the value
    """
    {
      "<response_key>":"<response_value>"
    }
    """
    Examples:
    |case_suffix             |payment_method |bank_country_code  |account_name |account_number   |swift_code |aba         |request_code |entity_name    |response_key |response_value       |
    |successful              |SWIFT           |US                  |John Lulu    |123               |ICBCUSBJ   |112233445  |200            |SuccessEntity |success      |Bank details saved  |
    |missing_country_code   |SWIFT           |                    |John Lulu    |123               |ICBCUSBJ   |112233445  |400            |ErrorEntity    |error        |'bank_country_code' is required, and should be one of 'US', 'AU', or 'CN' |
    |missing_account_name   |SWIFT           |US                  |              |123               |ICBCUSBJ   |112233445  |400            |ErrorEntity   |error         |'account_name' is required|
    |missing_account_number |SWIFT           |US                  |John Lulu    |                   |ICBCUSBJ   |112233445  |400            |ErrorEntity  |error          |'account_number' is required|
    |missing_swift_code     |SWIFT           |US                  |John Lulu    |123                |           |112233445  |400            |ErrorEntity   |error         |'swift_code' is required when payment method is 'SWIFT'|
    |missing_aba             |SWIFT           |US                  |John Lulu    |123               |ICBCUSBJ   |           |400            |ErrorEntity    |error         |'aba' is required when bank country code is 'US'|
    |short_account_name     |SWIFT           |US                  |ab            |123               |ICBCUSBJ   |112233445  |200            |SuccessEntity |success      |Bank details saved|
    |shorter_account_name   |SWIFT           |US                  |a             |123                |ICBCUSBJ   |112233445  |400            |ErrorEntity   |error         |Length of account_name should be between 2 and 10|
    |long_account_name      |SWIFT           |US                  |abcdefgh12   |123                |ICBCUSBJ   |112233445  |200            |SuccessEntity |success       |Bank details saved|
    |longer_account_name    |SWIFT           |US                  |abcdefgh123  |123                |ICBCUSBJ   |112233445  |400            |ErrorEntity   |error         |Length of account_name should be between 2 and 10|
    |short_account_number   |SWIFT           |US                  |John Lulu    |1                  |ICBCUSBJ   |112233445  |200            |SuccessEntity |success       |Bank details saved|
    |long_account_number    |SWIFT           |US                  |John Lulu    |12345678901234567 |ICBCUSBJ   |112233445  |200            |SuccessEntity |success       |Bank details saved|
    |longer_account_number  |SWIFT           |US                  |John Lulu    |123456789012345678|ICBCUSBJ   |112233445  |400            |ErrorEntity   |error         |Length of account_number should be between 1 and 17|
    |swift_code_not_us      |SWIFT           |US                  |John Lulu    |123                |ICBCCNBJ   |112233445  |400            |ErrorEntity   |error         |The swift code is not valid for the given bank country code: US|
    |swift_code_error_pos   |SWIFT           |US                  |John Lulu    |123                |ICBC1USBJ  |112233445  |400            |ErrorEntity   |error         |The swift code is not valid for the given bank country code: US|
    |long_swift_code        |SWIFT           |US                  |John Lulu    |123                |ICBCUSBJ123 |112233445  |200            |SuccessEntity |success      |Bank details saved|
    |longer_swift_code      |SWIFT           |US                  |John Lulu    |123                |ICBCUSBJ1234|112233445  |400            |ErrorEntity   |error         |Length of 'swift_code' should be either 8 or 11|
    |longer_aba             |SWIFT           |US                  |John Lulu    |123                |ICBCUSBJ     |11223344   |400            |ErrorEntity   |error         |Length of 'aba' should be 9|
    |short_aba              |SWIFT           |US                  |John Lulu    |123                |ICBCUSBJ     |1122334456 |400            |ErrorEntity   |error         |Length of 'aba' should be 9|

  Scenario Outline: SWIFT_in_AU_<case_suffix>
    When Request method is POST
    And Set content type is json, body is
    """
    {
      "payment_method": "<payment_method>",
      "bank_country_code": "<bank_country_code>",
      "account_name": "<account_name>",
      "account_number": "<account_number>",
      "swift_code": "<swift_code>",
      "bsb": "<bsb>"
    }
    """
    And Send the request
    Then Assert the code is <request_code>
    Then Assert body is <entity_name> with the value
    """
    {
      "<response_key>":"<response_value>"
    }
    """
    Examples:
    |case_suffix             |payment_method |bank_country_code  |account_name |account_number   |swift_code |bsb         |request_code |entity_name    |response_key |response_value       |
    |successful              |SWIFT           |AU                  |John Lulu    |123456            |ICBCAUBJ   |112233      |200          |SuccessEntity  |success      |Bank details saved  |
    |missing_bsb             |SWIFT           |AU                  |John Lulu    |123456            |ICBCAUBJ   |            |400          |ErrorEntity    |error        |'bsb' is required when bank country code is 'AU' |
    |long_account_number    |SWIFT           |AU                  |John Lulu    |123456789         |ICBCAUBJ   |112233      |200          |SuccessEntity  |success      |Bank details saved |
    |longer_account_number  |SWIFT           |AU                  |John Lulu    |1234567890        |ICBCAUBJ   |112233      |400          |ErrorEntity    |error        |Length of account_number should be between 6 and 9 |
    |shorter_account_number |SWIFT           |AU                  |John Lulu    |12345             |ICBCAUBJ   |112233      |400          |ErrorEntity    |error        |Length of account_number should be between 6 and 9 |
    |shorter_bsb             |SWIFT           |AU                  |John Lulu    |123456            |ICBCAUBJ   |11223       |400          |ErrorEntity    |error        |Length of 'bsb' should be 6 |
    |longer_bsb              |SWIFT           |AU                  |John Lulu    |123456            |ICBCAUBJ   |1122334     |400          |ErrorEntity    |error        |Length of 'bsb' should be 6 |

  Scenario Outline: SWIFT_in_CN_<case_suffix>
    When Request method is POST
    And Set content type is json, body is
    """
    {
      "payment_method": "<payment_method>",
      "bank_country_code": "<bank_country_code>",
      "account_name": "<account_name>",
      "account_number": "<account_number>",
      "swift_code": "<swift_code>"
    }
    """
    And Send the request
    Then Assert the code is <request_code>
    Then Assert body is <entity_name> with the value
    """
    {
      "<response_key>":"<response_value>"
    }
    """
    Examples:
    |case_suffix             |payment_method |bank_country_code  |account_name |account_number      |swift_code |request_code |entity_name    |response_key |response_value       |
    |successful              |SWIFT           |CN                  |John Lulu    |12345678             |ICBCCNBJ   |200          |SuccessEntity  |success      |Bank details saved  |
    |long_account_number    |SWIFT           |CN                  |John Lulu    |12345678901234567890 |ICBCCNBJ   |200          |SuccessEntity  |success      |Bank details saved  |
    |shorter_account_number |SWIFT           |CN                  |John Lulu    |1234567               |ICBCCNBJ   |400          |ErrorEntity    |error        |Length of account_number should be between 8 and 20   |
    |longer_account_number  |SWIFT           |CN                  |John Lulu    |123456789012345678901|ICBCCNBJ   |400          |ErrorEntity    |error        |Length of account_number should be between 8 and 20   |

  Scenario: LOCAL_in_US_success
    When Request method is POST
    And Set content type is json, body is
    """
    {
      "payment_method": "LOCAL",
      "bank_country_code": "US",
      "account_name": "John Lulu",
      "account_number": "1",
      "aba": "112233445"
    }
    """
    And Send the request
    Then Assert the code is 200
    Then Assert body is SuccessEntity with the value
    """
    {
      "success":"Bank details saved"
    }
    """

  Scenario: LOCAL_in_AU_success
    When Request method is POST
    And Set content type is json, body is
    """
    {
      "payment_method": "LOCAL",
      "bank_country_code": "AU",
      "account_name": "John Lulu",
      "account_number": "123456",
      "bsb": "112233"
    }
    """
    And Send the request
    Then Assert the code is 200
    Then Assert body is SuccessEntity with the value
    """
    {
      "success":"Bank details saved"
    }
    """

  Scenario: LOCAL_in_CN_success
    When Request method is POST
    And Set content type is json, body is
    """
    {
      "payment_method": "LOCAL",
      "bank_country_code": "CN",
      "account_name": "John Lulu",
      "account_number": "12345678"
    }
    """
    And Send the request
    Then Assert the code is 200
    Then Assert body is SuccessEntity with the value
    """
    {
      "success":"Bank details saved"
    }
    """

  Scenario: error_payment_method
    When Request method is POST
    And Set content type is json, body is
    """
    {
      "payment_method": "ABC",
      "bank_country_code": "CN",
      "account_name": "John Lulu",
      "account_number": "12345678"
    }
    """
    And Send the request
    Then Assert the code is 400
    Then Assert body is ErrorEntity with the value
    """
    {
      "error":"'payment_method' field required, the value should be either 'LOCAL' or 'SWIFT'"
    }
    """