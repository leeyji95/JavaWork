(function(){
    // 왼쪽음료
    var $object01 = $(".object01 img");
    var $object01_01 = $(".object01_01 img");
    var $object01_02 = $(".object01_02 img");
    var $object02 = $(".object02 img");
    var $object02_01 = $(".object02_01 img");
    var $object02_02 = $(".object02_02 img");

    $object01.css({'left':'-220px'});
    $object02.css({'left':'1800px'});

    
    // 화면 최초 왼오에서 날라옴
    // (function beverage(){
    //     $object01.animate({'left':'380px'}, 2000);
    //     // $object02.animate({'left':'1250px'}, 2000);
    // })();
    
    
    $.when($object01.animate({'left':'380px'},2000))
        .then(function(){loopShake();
    });
    $.when($object02.animate({'left':'1250px'},2000))
        .then(function(){loopShake();
    });
    
   
    
    
    
    
    function loopShake(){
        $object01
            .animate({'top' :'35px'}, 700)
            .animate({'top':'20px'}, 700, loopShake);
        $object02
        .animate({'top' :'35px'}, 700)
        .animate({'top':'20px'}, 700, loopShake);

    }
})();
  