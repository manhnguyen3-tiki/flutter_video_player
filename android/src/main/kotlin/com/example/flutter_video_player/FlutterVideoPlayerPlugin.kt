package com.example.flutter_video_player

import com.example.flutter_video_player.audio.AudioPlayer
import com.example.flutter_video_player.video.PlayerViewFactory
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.PluginRegistry.Registrar

class FlutterVideoPlayerPlugin : FlutterPlugin {

  fun FlutterVideoPlayerPlugin() {}

  companion object {
    @JvmStatic
    fun registerWith(registrar: Registrar) {
      PlayerViewFactory.registerWith(registrar)
      AudioPlayer.registerWith(registrar)
    }

    fun registerWithV2(engine: FlutterEngine) {
      val plugin = PlayerViewFactory(engine.dartExecutor.binaryMessenger, null)
      engine
        .platformViewsController
        .registry
        .registerViewFactory("tk.vn/NativeVideoPlayer", plugin)
    }
  }

  override fun onAttachedToEngine(binding: FlutterPluginBinding) {
    val plugin = PlayerViewFactory(binding.binaryMessenger, null)
    binding
      .platformViewRegistry
      .registerViewFactory("tk.vn/NativeVideoPlayer", plugin)
  }

  override fun onDetachedFromEngine(binding: FlutterPluginBinding) {}
}
