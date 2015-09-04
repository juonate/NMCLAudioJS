<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>Gender-wise Pass Percentage</title>

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
        <script src="http://code.highcharts.com/highcharts.js"></script>

    </head>

    <body>
        <div>
            <table>
                <tr>
                    <td align="center">
                        <div id="outerDiv" style="width:100%">
                            <div  id="placeholder"></div>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
        <script type="text/javascript">
 
$(function() {
    console.log("inicio script");
    generateChart();
 
  });
 
function passpercentage(json) {
 
    $(function () {
 
        var len = json.passpercentage.length
        i = 0;
        console.log(len);
 
        var options = {
             chart: {
                    type: 'line'
                },
             credits: {
                 enabled: false
                },
            title: {
                text: 'Audiograma'
             },
              yAxis: {
                  title: {
                      text: 'Intensidad(HL)'
                  },
                min: -10,
                max: 110,
                tickInterval: 5,
                reversed: true
            },
            xAxis: {
                title: {
                    text: 'Frecuencia(Hz)',
                },
                categories: ['125','250','500','1000','2000','3000','4000', '6000', '8000']
            },
            series: []
        }
 
            for (i; i < len; i++) {
                    options.series.push(json.passpercentage[i]);
            }
 
        $('#placeholder').highcharts(options);
 
    });
 
    }
 
function generateChart()
{
vaod = getQueryVariable("VAOD");
vaoi = getQueryVariable("VAOI");
vood = getQueryVariable("VOOD");
vooi = getQueryVariable("VOOI");
chartType="passpercentage";
$("#placeholder").text("");
 
     $.ajax({
            type: "GET",
            url:"http://mssiww04.mutualseg.cl:8080/NMCLAudioJS/GetAudioDetails?jsonp="+chartType + "&VAOD=" + vaod + "&VAOI=" + vaoi + "&VOOD=" + vood +"&VOOI="+vooi,
            dataType: 'jsonp',
            jsonpCallback: chartType, // the function to call
            error: function () {
                   alert("Error is occured");
                    }
            }); 
 
}
function getQueryVariable(variable) {
                var query = window.location.search.substring(1);
                var vars = query.split("&");
                for (var i = 0; i < vars.length; i++) {
                    var pair = vars[i].split("=");
                    if (pair[0] == variable) {
                        return pair[1];
                    }
                }
                alert('Query Variable ' + variable + ' not found');
            }
 
</script>

    </body>
</html>

