package echo.music.iad1tya.expect

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import org.koin.mp.KoinPlatform.getKoin
import java.io.File

actual fun installDownloadedApk(apkBytes: ByteArray, fileName: String): Boolean {
    return try {
        val context: AppCompatActivity = getKoin().get()
        val updateFile = File(context.cacheDir, fileName)
        updateFile.writeBytes(apkBytes)

        val apkUri =
            FileProvider.getUriForFile(
                context,
                "${context.packageName}.FileProvider",
                updateFile,
            )
        val intent =
            Intent(Intent.ACTION_VIEW).apply {
                setDataAndType(apkUri, "application/vnd.android.package-archive")
                addFlags(FLAG_GRANT_READ_URI_PERMISSION)
                addFlags(FLAG_ACTIVITY_NEW_TASK)
            }
        context.startActivity(intent)
        true
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}
