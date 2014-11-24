WarDriver
=========

WarDriver allows you to easily conduct a Wi-Fi survey and upload it to the WarDriver repository. It uses the powerful kismet backbone to find wireless access points and provides you an easy to use GUI for surveying on the go. This particular version was built for a touch screen Raspberry Pi using the Adafruit PiTFT 2.8" screen.

<h2>Requirements</h2>
<ul>
<li>Kismet</li>
<li>Java 8</li>
<li>MongoDB</li>
<li>External USB wireless card capable of monitor mode</li>
<li>USB GPS Receiver</li>
</ul>

<h2>Use</h2>
In order to use WarDriver in its current state, you must compile and run WarDriver as well as start the kismet server
<h3>Starting the Kismet server</h3>
kismet_server -c wlan0 -n 
