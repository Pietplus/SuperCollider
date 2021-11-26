// **********SERVERSIDE**********
s.boot;  // boot sserver
/*s.plotTree;*/ // make node tree...
s.meter;  // lvl-meter

s.reboot;

"open -a 'Audio MIDI Setup'".unixCmd; // execute this to launch it

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




// **********MAIN**********
