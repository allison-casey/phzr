(ns phzr.impl.accessors.sound.web-audio-sound)

(def web-audio-sound-get-properties
  {:current-marker "currentMarker"
   :detune "detune"
   :duration "duration"
   :is-paused "isPaused"
   :is-playing "isPlaying"
   :key "key"
   :loop "loop"
   :markers "markers"
   :mute "mute"
   :rate "rate"
   :seek "seek"
   :total-duration "totalDuration"
   :total-rate "totalRate"
   :volume "volume"})

(def web-audio-sound-set-properties
  {:detune "detune"
   :loop "loop"
   :mute "mute"
   :rate "rate"
   :seek "seek"
   :volume "volume"})