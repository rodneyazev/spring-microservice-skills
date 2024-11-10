POST http://localhost:8081/api/order

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