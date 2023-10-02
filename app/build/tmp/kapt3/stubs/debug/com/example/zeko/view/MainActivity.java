package com.example.zeko.view;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.compose.material.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.tooling.preview.Preview;
import com.example.zeko.viewmodel.PostViewModel;
import dagger.hilt.android.AndroidEntryPoint;
import com.example.zeko.data.model.PostEntity;
import com.example.zeko.utils.receiver.NetworkCheckReceiver;
import com.example.zeko.utils.receiver.NetworkChecker;
import com.example.zeko.viewmodel.UserViewModel;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\nH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/example/zeko/view/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "connectivityReceiver", "Lcom/example/zeko/utils/receiver/NetworkCheckReceiver;", "networkChecker", "Lcom/example/zeko/utils/receiver/NetworkChecker;", "getNetworkChecker", "()Lcom/example/zeko/utils/receiver/NetworkChecker;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class MainActivity extends androidx.activity.ComponentActivity {
    @org.jetbrains.annotations.NotNull
    private final com.example.zeko.utils.receiver.NetworkChecker networkChecker = null;
    private final com.example.zeko.utils.receiver.NetworkCheckReceiver connectivityReceiver = null;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.zeko.utils.receiver.NetworkChecker getNetworkChecker() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
}