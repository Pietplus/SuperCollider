// **********SERVERSIDE*********

s.boot;  // boot sserver
/*s.plotTree;*/ // make node tree...
s.meter;  // lvl-meter

s.reboot;

"open -a 'Audio MIDI Setup'".unixCmd; // execute this to launch it

Server.killAll // -> KIll every Action of the Server.



// **********Recording_SETTINGS**********

// Record the Sound:
s.makeWindow;


// Recording STOP
s.stopRecording;
s.recHeaderFormat; // = "wav"    set file format to wav
s.recSampleFormat; // = "int32"; set samplerate
s.recChannels;

// Get the Path of your Record:
Platform.recordingsDir;
// same:
thisProcess.platform.recordingsDir;

FreqScope.new;



// **********ABLETONINTERFACE_RECAP**********

s.options.dump;

ServerOptions.devices;
// Check wich devices are available!


(
s.options.device = "BlackHole 16ch";
s.options.numOutputBusChannels = 16;
s.reboot;
)


// **********************Basic Additive Syntesis*****************************

// +10Hz

(
{SinOsc.ar([200,210],0,0.1)}.scope
)

// -10hz

(
{SinOsc.ar([200,190],0,0.1)}.scope
)

// +12hz

(
{SinOsc.ar([200,212],0,0.1)}.scope
)

// -12hz
(
{SinOsc.ar([200,210,190,212,188],0,0.1)}.scope
)


// all together:
(
{SinOsc.ar([200,210,190,212,188],0,0.1)}.scope
)

// further exploration:
// Fm Oscilator found: 3 argument is feedback(plugs output into input.)
(
{
	SinOscFB.ar([100,200,800,500,1000,2000],1,1,0.1)
}.scope
)

// try to make an Ndef:

(
Ndef(\player, {|amp = 0.1|
	// definition
	SinOsc.ar([ExpRand(100, 1000),ExpRand(100, 1000),ExpRand(100, 1000)]) * amp!2;
	// ...
})
)

Ndef(\player).play;
Ndef(\player).clear;


// Try the same with the SinOscFb:

(
Ndef(\gamer, {|amp = 0.1|
	// definition
	SinOscFb.ar([ExpRand(100, 1000),ExpRand(100, 1000),ExpRand(100, 1000),1,1,0.1]) * amp!2;
	// ...
})
)

Ndef(\gamer).play;
Ndef(\gamer).clear; -> Error!

// Sawtooth************************************

(
{
	var n = 10;

	var wave = Mix.fill(10,{|i|
		var mult = ((-1)**i)*(0.5/((i+1)));

		SinOsc.ar(440*(i+1))*mult
	});

	Pan2.ar(wave/n,0.2); // stereo panned to centre

}.scope;
)


// Square************************************

(
{
	var n = 10;

	var wave = Mix.fill(10,{|i|
			var harmonicnumber = 2*i+1; //odd harmonics only
			SinOsc.ar(440*harmonicnumber)/harmonicnumber
		})*0.25;

	Pan2.ar(wave,0.0); //stereo, panned centre

}.scope;
)

// Triangle************************************

(
{
	var n = 10;

	var wave = Mix.fill(10,{|i|

		var harmonicnumber= 2*i+1; //odd harmonics only
    	var mult= ((-1)**((harmonicnumber-1)/2))*(1.0/(harmonicnumber*harmonicnumber));

    SinOsc.ar(440*1)*mult })/n;

	Pan2.ar(wave,0.0); //stereo, panned centre

}.scope;
)

// Bell Sound ************************************
500*[0.5,1,1.19,1.56,2,2.51,2.66,3.01,4.1];

(
{Mix(SinOsc.ar(500*[0.5,1,1.19,1.56,2,2.51,2.66,3.01,4.1],0,0.1))}.scope //bell spectra, all partials the same volume
)


(
{Mix(SinOsc.ar(500*[0.5,1,1.19,1.56,2,2.51,2.66,3.01,4.1],0,0.1*[0.25,1,0.8,0.5,0.9,0.4,0.3,0.6,0.1]))}.scope //bell spectra, different volumes for partials
)

(1..10) // write down the numbers from 1 to 10.

(
var n = 10;
{
	Mix(SinOsc.ar(250*(1..n),0,1/n))
}.scope;
)










