# REST API

### Get parking by id

*rs/parkingService/parking/{id}*

```
{
  id: 1,
  name: "The Crossroads on st.Lenin",
  source: "http://webcam.211.ru/camera54_6/index.m3u8",
  lastUpdate: 1454166655831,
  lastImage: "/1/1454153246.jpg",
  coordinate: {
    x: 74.3,
    y: 36.2
  },
  places: [
    {
      id: 10,
      empty: true,
      rectangle: {
        minLeft: {
          x: 10,
          y: 10
        },
        minRight: {
          x: 13,
          y: 40
        },
        maxLeft: {
          x: 30,
          y: 30
        },
        maxRight: {
          x: 40,
          y: 60
        }
      }
    },
    {
      id: 11,
      empty: true,
      rectangle: {
        minLeft: {
          x: 110,
          y: 10
        },
        minRight: {
          x: 113,
          y: 40
        },
        maxLeft: {
          x: 130,
          y: 30
        },
        maxRight: {
          x: 140,
          y: 60
        }
      }
    }
  ]
}
```