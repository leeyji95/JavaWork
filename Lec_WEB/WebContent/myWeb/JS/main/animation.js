(function(){
    // 왼쪽음료
    var $object01 = $(".object01");
    var $cheese1 = $(".cheese1");
    var $cheese2 = $(".cheese2");
    var $cheese3 = $(".cheese3");
    
    var $object02 = $(".object02");
    var $choco1 = $(".choco1");
    var $choco2 = $(".choco2");
    var $choco3 = $(".choco3");
    var $choco4 = $(".choco4");
    
    // 화면 최초 왼오에서 날라옴
    $object01.css({'left':'-400px'});
    $object01.animate({'left':'200px'}, 1500, function () {
        loopShake1();
    });
    $object02.css({'right':'-800px'});
    $object02.animate({'right':'-350px'}, 1500, function () {
        loopShake2();
    });
    
    
    
    function loopShake1(){
        $cheese1.animate({'top':'10px'}, 700)
        .animate({'top':'25px'}, 700, loopShake1);

        $cheese2.animate({'top':'-70px'}, 700)
        .animate({'top':'-85px'}, 700, loopShake1);

        $cheese3.animate({'top':'-170px'}, 700)
        .animate({'top':'-185px'}, 700, loopShake1);
    }

    function loopShake2(){
        $choco1.animate({'top':'-50px'}, 700)
        .animate({'top':'-65px'}, 700, loopShake2);

        $choco2.animate({'top':'-220px'}, 600)
        .animate({'top':'-230px'}, 600, loopShake2);

        $choco3.animate({'top':'-15px'}, 600)
        .animate({'top':'-5px'}, 600, loopShake2);
      
        $choco4.animate({'top':'-60px'}, 600)
        .animate({'top':'-75px'}, 600, loopShake2);
    }


})();
  