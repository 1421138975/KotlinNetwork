package com.dfzt.kotlinnetwork.entity

/**
 *
 * {
    "error": false,
    "results": [{
            "_id": "58fd4b4a421aa9544825f8f7",
            "createdAt": "2017-04-24T08:48:10.92Z",
            "desc": "4-24",
            "publishedAt": "2017-04-24T11:35:03.680Z",
            "source": "chrome",
            "type": "\u798f\u5229",
            "url": "http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-24-18094714_158946097967074_5909424912493182976_n.jpg",
            "used": true,
            "who": "dmj"
            }, {
            "_id": "58f95b74421aa954511ebedf",
            "createdAt": "2017-04-21T09:08:04.293Z",
            "desc": "4-21",
            "publishedAt": "2017-04-21T11:30:29.323Z",
            "source": "chrome",
            "type": "\u798f\u5229",
            "url": "http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-21-18013964_1389732981073150_4044061109068496896_n.jpg",
            "used": true,
            "who": "daimajia"
            }, {
            "_id": "58f8043e421aa9544ed88993",
            "createdAt": "2017-04-20T08:43:42.333Z",
            "desc": "4-20",
            "publishedAt": "2017-04-20T14:03:06.490Z",
            "source": "chrome",
            "type": "\u798f\u5229",
            "url": "http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-20-17932350_1238028809599424_2089669844847820800_n.jpg",
            "used": true,
            "who": "daimajia"
            }, {
            "_id": "58f6baad421aa954511ebec3",
            "createdAt": "2017-04-19T09:17:33.987Z",
            "desc": "4-19",
            "publishedAt": "2017-04-19T11:44:51.925Z",
            "source": "chrome",
            "type": "\u798f\u5229",
            "url": "http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-19-17881407_1845958195665029_1132383288824954880_n.jpg",
            "used": true,
            "who": "daimajia"
            }, {
            "_id": "58f5649b421aa9544825f89f",
            "createdAt": "2017-04-18T08:58:03.511Z",
            "desc": "4-18",
            "publishedAt": "2017-04-18T11:34:29.203Z",
            "source": "chrome",
            "type": "\u798f\u5229",
            "url": "http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-18-17882540_190116561497334_440657494176432128_n.jpg",
            "used": true,
            "who": "\u5e26\u9a6c\u7532"
            }, {
            "_id": "58f3980c421aa9544b773ff1",
            "createdAt": "2017-04-17T00:13:00.136Z",
            "desc": "4-17",
            "publishedAt": "2017-04-17T11:32:14.674Z",
            "source": "chrome",
            "type": "\u798f\u5229",
            "url": "http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-16-17934400_1738549946443321_2924146161843437568_n.jpg",
            "used": true,
            "who": "daimajia"
            }, {
            "_id": "58f0438f421aa9544825f873",
            "createdAt": "2017-04-14T11:35:43.995Z",
            "desc": "4-14",
            "publishedAt": "2017-04-14T11:46:48.47Z",
            "source": "chrome",
            "type": "\u798f\u5229",
            "url": "http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-14-17881962_1329090457138411_8289893708619317248_n.jpg",
            "used": true,
            "who": "\u4ee3\u7801\u5bb6"
            }, {
            "_id": "58eef016421aa9544b773fd0",
            "createdAt": "2017-04-13T11:27:18.557Z",
            "desc": "4-13",
            "publishedAt": "2017-04-13T11:36:04.435Z",
            "source": "chrome",
            "type": "\u798f\u5229",
            "url": "http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-13-17882785_926451654163513_7725522121023029248_n.jpg",
            "used": true,
            "who": "dmj"
            }, {
            "_id": "58ed8242421aa9544b773fc1",
            "createdAt": "2017-04-12T09:26:26.434Z",
            "desc": "4-12",
            "publishedAt": "2017-04-12T12:12:18.213Z",
            "source": "chrome",
            "type": "\u798f\u5229",
            "url": "http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-12-17662441_1675934806042139_7236493360834281472_n.jpg",
            "used": true,
            "who": "daimajia"
            }, {
            "_id": "58ec30e4421aa9544ed88919",
            "createdAt": "2017-04-11T09:27:00.840Z",
            "desc": "4-11",
            "publishedAt": "2017-04-11T14:43:34.738Z",
            "source": "chrome",
            "type": "\u798f\u5229",
            "url": "http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-11-17881546_248332202297978_2420944671002853376_n.jpg",
            "used": true,
            "who": "dmj"
            }]
    }
 */

data class PhotoBean<T>(var error: String?,var results : List<T>)

/**
 *
 * {
    "_id": "58fd4b4a421aa9544825f8f7",
    "createdAt": "2017-04-24T08:48:10.92Z",
    "desc": "4-24",
    "publishedAt": "2017-04-24T11:35:03.680Z",
    "source": "chrome",
    "type": "\u798f\u5229",
    "url": "http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-24-18094714_158946097967074_5909424912493182976_n.jpg",
    "used": true,
    "who": "dmj"
  }
 *
 */
data class PhotoData(var _id: String?,var createdAt: String?,var desc: String?
                     ,var publishedAt: String?,var source: String?
                     ,var type: String?,var url: String?,var used: Boolean = false,
                     var who: String?)

