angular.
  module('phonecatApp').
  animation('.phone', function phoneAnimationFactory() {
    return {
      addClass: animateIn,
      removeClass: animateOut
    };

    function animateIn(element, className, done) {
        console.log(element);
      if (className !== 'selected') return;

      element.css({
          display: 'block',
          position: 'absolute',
          bottom: 500,
          left: 0
        }).
        animate({
          top: 0
        }, done);

      return function animateInEnd(wasCanceled) {
        if (wasCanceled) element.stop();
      };
    }

    function animateOut(element, className, done) {
         console.log(element);
      if (className !== 'selected') return;

      element.css({
          position: 'absolute',
          top: 0,
          left: 0
        }).
        animate({
         left: -500
        }, done);

      return function animateOutEnd(wasCanceled) {
          
        if (wasCanceled) element.stop();
      };
    }
  });