Currency Convertor:

Spring boot application to provide a wrapper for currency conversion api.

Solution Design Explanantion:

Solution is designed based on following assumptions:

1. Real-time exchange data should be used to convert and hence api is being hit in each request.
2. Limit on input length has been added in UI. Backend, the limit is as per Double Object in Java and extra zeros will be added while converting to string
3. Exchange Rates are picked from open source api.
4. Decimal places per currency has been configured in application.properties and again has been referenced from open source.(Refernce provided in comments)

End Point Exposed:

POST: /api/v1/currency/convert
Sample Request Payload: 
{
  "sourceCurrency": "USD"
  "targetCurrency": "INR"
  "sourceAmount": 1001.2
}

Sample Response Payload:

{
  targetCurrency: "INR",
  targetAmount: "83,249.78",
  error:null
}

Files Present:

1. Spring boot project : inside liftlab-currency-converter
2. currency_converter.html : Basic html+css+JS based UI to pass down the params

Note: Cross Origin has been enabled to integrate api with UI locally.

In HTML file please change the end point address if not running on same machine.

System Requirements:
Java version 15 has been used so make sure compile and run version is set to same.

How to Run the Project:
  Backend:
  Following command can be used to build the project.
          mvn clean install
          and then running the jar
  or it can be run directly using
          mvn spring-boot:run

  This will start the application at localhost:8080 (Default Port)

FrontEnd:
  Open the  currency_converter.html in any browser which should load the UI and is already pointing to localhost:8080

Or it can be run in any desire IDE as spring boot application.

Addition Note:
Alternative Implementation:

A data base based solution can be implemented where the currency rates from exchange can be refreshed in database everyday(or any desired frequency) with CRON based scheduler.
This approach will reduce the api hits and will fetch data from DB but will reduce the accuracy. 
Current approach has been chosen based on assumption that real time data is needed


  

  
