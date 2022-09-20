# CamelProject

1.	As User, I want to create workflow that transfers data from one file system to another.
  a.	C:/test/input
  b.	C:/test/output
 
2.	As User, I want to create workflow that transfers data from one file system to IBMMQ/ActiveMQ.

3.	As User, I want to create workflow that transfers data from IBMMQ to IBMMQ/ActiveMQ.
  a.	Insert the payload and headers into database (MSSQL)
    i.	ID (primary key, UUID)
    ii.	stageId - 1, 2
    iii.	Payload
    iv.	Headers

4.	Generate code value from database and add it to the target payload  (getUniqueCode, 00000, 00001, 00002))
  a.	Input: 
    {
      "customerId":"12345",
      "customerName":"test",
      "address":{
        "address1":"abc",
        "address2":"def"
      }
    }
    
  b.	output
    {
      "customerId":"12345",
      "customerName":"test",
      "code":"00000"
      "address":{
        "address1":"abc",
        "address2":"def"
      }
    }
 
5.	Transformation  (java logic , mapstruct) 
  {
    "customerId":"12345",
    "customerName":"test",
    "address":{
      "address1":"abc",
      "address2":"def"
    }
  }
  
  {
    "customerId":"12345",
    "customerName":"test",
    "code":"12345"
    "customerAdress1":"abc",
    "customerAdress2":"def"
  }
