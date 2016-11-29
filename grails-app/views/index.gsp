<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Eduvisor</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:javascript src="typed.min.js"/>
    <asset:javascript src="wow.js"/>
</head>

<body>

<script>
    var wow = new WOW(
            {
                boxClass: 'wow',      // animated element css class (default is wow)
                animateClass: 'animated', // animation css class (default is animated)
                offset: 0,          // distance to the element when triggering the animation (default is 0)
                mobile: true,       // trigger animations on mobile devices (default is true)
                live: true,       // act on asynchronously loaded content (default is true)
                callback: function (box) {
                    // the callback is fired every time an animation is started
                    // the argument that is passed in is the DOM node being animated
                },
                scrollContainer: null // optional scroll container selector, otherwise use window
            }
    );
    wow.init();
</script>
<section>
    <div class="card transparent" id="banner">
        <div class=" text-center">
            <div class="type-wrap row">
                <div id="typed-strings">
                    <p>academics,</p>

                    <p>finance,</p>

                    <p>career advancement.</p>
                </div>

                <h3 class="white-text text-lighten-2 center">
                    <span class="glyphicons glyphicons-education"></span>Unparallel Counselling on <strong><span
                        id="typed" style="white-space: pre;"></span></strong>
                </h3>
            </div>

            <h5 class="white-text text-lighten-2 center">...helping you in your career advancement</h5>
        </div><br><br><br>

        <g:form >
        <div class="row center">
            <div class="col l4">
                <g:textField value="university" name="university"/>
            </div>
            <div class="col l4">
                <g:textField value="university" name="university"/>
            </div>
            <div class="col l4">
                <g:textField value="university" name="university"/>
            </div>
            <g:submitButton name="get Suggestion" class="btn"/>
        </div>
        </g:form>

        <script>
            $(function () {

                $("#typed").typed({
                    stringsElement: $('#typed-strings'),
                    typeSpeed: 100,
                    backDelay: 2000,
                    loop: true,
                    contentType: 'html', // or text
                    // defaults to false for infinite loop
                    loopCount: false,
                    callback: function () {
                        foo();
                    },
                    resetCallback: function () {
                        newTyped();
                    }
                });

                $(".reset").click(function () {
                    $("#typed").typed('reset');
                });

            });

            function newTyped() { /* A new typed object */
            }

            function foo() {
                console.log("Callback");
            }

        </script>

        <style>
        /* code for animated blinking cursor */
        .typed-cursor {
            opacity: 1;
            font-weight: 100;
            -webkit-animation: blink 0.7s infinite;
            -moz-animation: blink 0.7s infinite;
            -ms-animation: blink 0.7s infinite;
            -o-animation: blink 0.7s infinite;
            animation: blink 0.7s infinite;
        }

        @
        @-keyframes blink {
        0% {
            opacity: 1;
        }
        50% {
            opacity: 0;
        }
        100% {
            opacity: 1;
        }
        }
        @
        @-webkit-keyframes blink {
            0% {
                opacity: 1;
            }
            50% {
                opacity: 0;
            }
            100% {
                opacity: 1;
            }
        }

        @
        @-moz-keyframes blink {
            0% {
                opacity: 1;
            }
            50% {
                opacity: 0;
            }
            100% {
                opacity: 1;
            }
        }

        @
        @-ms-keyframes blink {
            0% {
                opacity: 1;
            }
            50% {
                opacity: 0;
            }
            100% {
                opacity: 1;
            }
        }

        @
        @-o-keyframes blink {
            0% {
                opacity: 1;
            }
            50% {
                opacity: 0;
            }
            100% {
                opacity: 1;
            }
        }
        </style>
    </div>
</section>
<div class="divider"></div>
<div class="more">
    <div class="row">
        <div class="col l6 center ">
            <div class="card-panel z-depth-1 animated fadeInLeftBig ">
                <h5>About us</h5>
                <div class="divider"></div>
                <p>Bassus, noster itineris tramitems etiam anhelare de fatalis, barbatus exemplar.
                Ecce,Indictio moris, tanquam superbus pulchritudine.</p>
                <button class="btn" >Read more...</button>
            </div>
        </div>
        <div class="col l6 center ">
            <div class="card-panel z-depth-1 animated fadeInRightBig">
                <h5>Subscribe to Newsletter</h5>
                <input type="email" class="input-field" placeholder="Email"/>
                <button class="btn" >Subscribe</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
