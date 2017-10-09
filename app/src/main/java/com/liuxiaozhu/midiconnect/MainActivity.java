package com.liuxiaozhu.midiconnect;

import android.hardware.usb.UsbDevice;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import jp.kshoji.driver.midi.activity.AbstractSingleMidiActivity;
import jp.kshoji.driver.midi.device.MidiInputDevice;
import jp.kshoji.driver.midi.device.MidiOutputDevice;

public class MainActivity extends AbstractSingleMidiActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //midi链接
    @Override
    public void onDeviceAttached(@NonNull UsbDevice usbDevice) {
        Log.e(TAG, "onDeviceAttached");
        //此方法已经废弃
    }

    @Override
    public void onMidiInputDeviceAttached(@NonNull MidiInputDevice midiInputDevice) {
        Log.e(TAG, "onMidiInputDeviceAttached");
        //钢琴键盘可以将midi传入到手机
        Toast.makeText(this, "设备ID：" + midiInputDevice.getUsbDevice().getDeviceId() + ",已链接", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onMidiOutputDeviceAttached(@NonNull MidiOutputDevice midiOutputDevice) {
        //手机可以将midi传入到钢琴键盘
        Log.e(TAG, "onMidiOutputDeviceAttached");
    }

    //midi断开
    @Override
    public void onDeviceDetached(@NonNull UsbDevice usbDevice) {
        Log.e(TAG, "onDeviceDetached");
        //此方法已经废弃
    }

    @Override
    public void onMidiInputDeviceDetached(@NonNull MidiInputDevice midiInputDevice) {
        Log.e(TAG, "onMidiInputDeviceDetached");
        //usb断开，钢琴键盘不可以将midi传入到手机
        Toast.makeText(this, "设备ID：" + midiInputDevice.getUsbDevice().getDeviceId() + ",已断开", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onMidiOutputDeviceDetached(@NonNull MidiOutputDevice midiOutputDevice) {
        Log.e(TAG, "onMidiOutputDeviceDetached");
        //usb断开，手机不可以将midi传入到钢琴键盘
    }

    @Override
    public void onMidiMiscellaneousFunctionCodes(@NonNull MidiInputDevice midiInputDevice, int i, int i1, int i2, int i3) {
        Log.e(TAG, "onMidiMiscellaneousFunctionCodes");
    }

    @Override
    public void onMidiCableEvents(@NonNull MidiInputDevice midiInputDevice, int i, int i1, int i2, int i3) {
        Log.e(TAG, "onMidiCableEvents");
    }

    @Override
    public void onMidiSystemCommonMessage(@NonNull MidiInputDevice midiInputDevice, int i, byte[] bytes) {
        Log.e(TAG, "onMidiSystemCommonMessage");
    }

    @Override
    public void onMidiSystemExclusive(@NonNull MidiInputDevice midiInputDevice, int i, byte[] bytes) {
        Log.e(TAG, "onMidiSystemExclusive");
    }

    /**
     * 钢琴手指抬起
     *
     * @param midiInputDevice
     * @param i
     * @param i1
     * @param i2
     * @param i3
     */
    @Override
    public void onMidiNoteOff(@NonNull MidiInputDevice midiInputDevice, int i, int i1, int i2, int i3) {
        Log.e(TAG, "onMidiNoteOff" + "NoteOn cable: " + i + ",  channel: " + i1 + ", note: " + i2 + ", velocity: " + i3);
    }

    /**
     * 钢琴手指按下
     *
     * @param midiInputDevice 输入的设备
     * @param i
     * @param i1
     * @param i2 键数代表键的位置
     * @param i3
     */
    @Override
    public void onMidiNoteOn(@NonNull MidiInputDevice midiInputDevice, int i, int i1, int i2, int i3) {
        Log.e(TAG, "onMidiNoteOn" + "NoteOn cable: " + i + ",  channel: " + i1 + ", note: " + i2 + ", velocity: " + i3);
    }

    @Override
    public void onMidiPolyphonicAftertouch(@NonNull MidiInputDevice midiInputDevice, int i, int i1, int i2, int i3) {
        Log.e(TAG, "onMidiPolyphonicAftertouch");
    }

    @Override
    public void onMidiControlChange(@NonNull MidiInputDevice midiInputDevice, int i, int i1, int i2, int i3) {
        Log.e(TAG, "onMidiControlChange");
    }

    @Override
    public void onMidiProgramChange(@NonNull MidiInputDevice midiInputDevice, int i, int i1, int i2) {
        Log.e(TAG, "onMidiProgramChange");
    }

    @Override
    public void onMidiChannelAftertouch(@NonNull MidiInputDevice midiInputDevice, int i, int i1, int i2) {
        Log.e(TAG, "onMidiChannelAftertouch");
    }

    @Override
    public void onMidiPitchWheel(@NonNull MidiInputDevice midiInputDevice, int i, int i1, int i2) {
        Log.e(TAG, "onMidiPitchWheel");
    }

    @Override
    public void onMidiSingleByte(@NonNull MidiInputDevice midiInputDevice, int i, int i1) {
        Log.e(TAG, "onMidiSingleByte");
    }

    @Override
    public void onMidiTimeCodeQuarterFrame(@NonNull MidiInputDevice midiInputDevice, int i, int i1) {
        Log.e(TAG, "onMidiTimeCodeQuarterFrame");
    }

    @Override
    public void onMidiSongSelect(@NonNull MidiInputDevice midiInputDevice, int i, int i1) {
        Log.e(TAG, "onMidiSongSelect");
    }

    @Override
    public void onMidiSongPositionPointer(@NonNull MidiInputDevice midiInputDevice, int i, int i1) {
        Log.e(TAG, "onMidiSongPositionPointer");
    }

    @Override
    public void onMidiTuneRequest(@NonNull MidiInputDevice midiInputDevice, int i) {
        Log.e(TAG, "onMidiTuneRequest");
    }

    @Override
    public void onMidiTimingClock(@NonNull MidiInputDevice midiInputDevice, int i) {
        Log.e(TAG, "onMidiTimingClock");
    }

    @Override
    public void onMidiStart(@NonNull MidiInputDevice midiInputDevice, int i) {
        Log.e(TAG, "onMidiStart");
    }

    @Override
    public void onMidiContinue(@NonNull MidiInputDevice midiInputDevice, int i) {
        Log.e(TAG, "onMidiContinue");
    }

    @Override
    public void onMidiStop(@NonNull MidiInputDevice midiInputDevice, int i) {
        Log.e(TAG, "onMidiStop");
    }

    @Override
    public void onMidiActiveSensing(@NonNull MidiInputDevice midiInputDevice, int i) {
        Log.e(TAG, "onMidiActiveSensing");
    }

    @Override
    public void onMidiReset(@NonNull MidiInputDevice midiInputDevice, int i) {
        Log.e(TAG, "onMidiReset");
    }
}
