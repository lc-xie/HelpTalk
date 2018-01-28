package com.example.stephen.helptalk.TTS;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import java.util.Locale;

/**
 * Created by stephen on 18-1-28.
 * 语音播放辅助类
 * 使用方法：
 *  1.获取TTSHelp类实例，传入context参数，构造方法里会初始化TextToSpeech
 *  2.调用playTTS(String str)方法，传入要播放的语音内容
 *  3.这里使用讯飞语音，需要安装讯飞语音并下载语音支持包
 */

public class TTSHelp {

    private TextToSpeech mSpeech;
    private Context context;

    private static final String TAG_TTS = "TTSHelp";

    public TTSHelp(Context context) {
        this.context=context;
        speechInit();//初始化
    }

    /**
     * 初始化TextToSpeech，在onCreate中调用
     */
    private void speechInit() {
        if (mSpeech != null) {
            mSpeech.stop();
            mSpeech.shutdown();
            mSpeech = null;
        }
        // 创建TTS对象
        mSpeech = new TextToSpeech(context, new TTSListener());
    }

    /**
     * 将文本用TTS播放
     *
     * @param str 播放的文本内容
     */
    public void playTTS(String str) {
        if (mSpeech == null) mSpeech = new TextToSpeech(context, new TTSListener());
        mSpeech.speak(str, TextToSpeech.QUEUE_FLUSH, null);
        //Log.i(TAG_TTS, "播放语音为：" + str);
    }

    private final class TTSListener implements TextToSpeech.OnInitListener {
        @Override
        public void onInit(int status) {
            Log.e(TAG_TTS, "初始化结果：" + (status == TextToSpeech.SUCCESS));
            int result = mSpeech.setLanguage(Locale.CHINESE);
            //如果返回值为-2，说明不支持这种语言
            Log.e(TAG_TTS, "是否支持该语言：" + (result != TextToSpeech.LANG_NOT_SUPPORTED));
        }
    }
    //释放资源
    public void destroyTTS() {
        if (mSpeech != null) {
            mSpeech.stop();
            mSpeech.shutdown();
            mSpeech = null;
        }
    }

}
