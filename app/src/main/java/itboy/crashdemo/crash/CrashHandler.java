package itboy.crashdemo.crash;

import android.os.Build;
import android.util.Log;

import java.io.*;
import java.util.ArrayList;

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static CrashHandler crashHandler;
    private static final String TAG = "CrashHandler";

    private CrashHandler() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static CrashHandler getInstall() {
        if (crashHandler == null) {
            synchronized (CrashHandler.class) {
                if (crashHandler == null) {
                    crashHandler = new CrashHandler();
                }
            }
        }
        return crashHandler;
    }


    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        Log.e(TAG, "------------崩溃开始------------");
        Log.e(TAG, "进程名称：" + getProcessName());
        Log.e(TAG, "线程名称：" + thread.getName());
        Log.e(TAG, "设备信息：" + getDefaultUserAgent());
        if (throwable != null) {
            Log.e(TAG, "崩溃信息：" + getThrowableStrRep(throwable));
        }
        Log.e(TAG, "------------崩溃结束------------");
    }

    public static String getProcessName() {
        try {
            File file = new File("/proc/" + android.os.Process.myPid() + "/" + "cmdline");
            BufferedReader mBufferedReader = new BufferedReader(new FileReader(file));
            String processName = mBufferedReader.readLine().trim();
            mBufferedReader.close();
            return processName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getThrowableStrRep(Throwable throwable) {
        if (throwable == null) {
            return "";
        }
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        throwable.printStackTrace(pw);
        pw.flush();
        LineNumberReader reader = new LineNumberReader(new StringReader(
                sw.toString()));
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
                line = reader.readLine();
            }
        } catch (IOException ex) {
            stringBuilder.append(ex.toString());
            stringBuilder.append("/n");
        }
        return stringBuilder.toString();
    }

    /**
     * Returns an HTTP user agent of the form
     * "Dalvik/1.1.0 (Linux; U; Android Eclair Build/MASTER)".
     */
    private static String getDefaultUserAgent() {
        StringBuilder result = new StringBuilder(64);
        result.append("Dalvik/");
        result.append(System.getProperty("java.vm.version")); // such as 1.1.0
        result.append(" (Linux; U; Android ");

        String version = Build.VERSION.RELEASE; // "1.0" or "3.4b5"
        result.append(version.length() > 0 ? version : "1.0");

        // add the model for the release build
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String model = Build.MODEL;
            if (model.length() > 0) {
                result.append("; ");
                result.append(model);
            }
        }
        String id = Build.ID; // "MASTER" or "M4-rc20"
        if (id.length() > 0) {
            result.append(" Build/");
            result.append(id);
        }
        result.append(")");
        return result.toString();
    }

}
