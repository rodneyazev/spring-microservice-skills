<p align="center">
  <img src="https://i.imgur.com/Lxfk9IE.png" width="400" alt="Spring Boot Logo" />
</p>

## Description

Spring Microservice - Order Service API Example

```bash

# - order-service

POST http://localhost:8081/api/order

    {
        "orderLineItemsDtoList": [
            {
                "skuCode":"iphone_15",
                "price": 1200,
                "quantity": 1
            }
        ]
    }

    or

    {
        "orderLineItemsDtoList": [
            {
                "skuCode":"iphone_15",
                "price": 1200,
                "quantity": 1
            },
                {
                "skuCode":"iphone_15_black",
                "price": 1200,
                "quantity": 1
            }
        ]
    }

	
```