 // Boot the Server
s.boot;
// Reboot
s.reboot;


// Sequence 1:
// Standart like Eli did.


(
x = {
	var sig, freq, amp, reverb;
	freq = LFNoise0.ar(6!8).exprange(60,2500).round(20);
	amp = VarSaw.ar(0.5,2,0.004).range(0,1).pow(2);
	sig = LFTri.ar(freq);
	sig = sig / amp * 0.2;
	sig = Splay.ar(sig);
}.play(fadeTime:9);
)

// Sequence 2:
// wrap everything into a routine a make the record device wait for action.

(
Routine({

	s.record(// arg to store the file *Put in Path-make the Path unique ever<time,duration:4rec lenght);

	wait(0.02);


x = {
	var sig, freq, amp, reverb;
	freq = LFNoise0.ar(8!8).exprange(60,8500).round(60);
	amp = VarSaw.ar(5.456,1,0.004).range(0,2).pow(2);
	sig = LFTri.ar(freq);
	sig = sig / amp * 0.2;
	sig = Splay.ar(sig);
}.play(fadeTime:5);
}).play;
)


x.release(2);


// ****Recording_SETTINGS****
// Recording STOP
s.stopRecording;
s.recHeaderFormat; // = "wav"    Set file Format to wav
s.recSampleFormat; // = "int32"; Set Samplerate
s.recChannels;


// Record the Sound:
s.makeWindow;

// Get the Path of your Record:
Platform.recordingsDir;
