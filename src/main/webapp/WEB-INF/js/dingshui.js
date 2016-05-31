wx.config({
          debug: true,
          appId: "{$signature['appid']}",
          timestamp: {$signature['timeStamp']},
          nonceStr: "{$signature['nonceStr']}",
          signature: "{$signature['signature']}",
          jsApiList: [
                        'addCard'
                     ]
});

wx.ready(function(){
     document.querySelector('#addCard').onclick = function () {
     wx.addCard({
     cardList: [{
            cardId: "xxxxxxxxxxxxxxxxxxxxxx",
            cardExt: '{"timestamp":"1426222398","signature":"fdd892770eb681e925f92acb9015c75107b2227a"}'
            }],
            success: function (res) {
                alert('已添加卡券：' + JSON.stringify(res.cardList));
            }
            });
      };
});