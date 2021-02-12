#Project repository for JavaND
##Order service



# create a client
`POST /service/order/client`

```json
{
  "name": "xavier"
}
```


# add a order
`POST /service/order/{name}`

```json
{
  "quantity": 1,
  "value": 20,
  "vehicleId" : 1
}
```

#checkout 
`GET /service/order/{name}`