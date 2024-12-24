# Broadcast Receiver in Android

## Overview
Broadcast Receivers are one of the four essential components of Android. They are used to listen for and respond to system-wide or application-specific broadcast messages. These messages can come from other applications or from the Android system itself.

### Types of Broadcasts
1. **Normal Broadcasts**: Delivered to all receivers in an undefined order.
2. **Ordered Broadcasts**: Delivered to one receiver at a time in a specified order.
3. **Sticky Broadcasts**: Remain in the system after being broadcast and can be retrieved by future receivers.

## Key Components
1. **Intent**: Used to broadcast and receive messages.
2. **BroadcastReceiver Class**: The base class for handling broadcast messages.
3. **AndroidManifest.xml**: Used to register broadcast receivers statically.

## Creating a Broadcast Receiver

### Steps:
1. **Define a Receiver Class**
```java
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Toast.makeText(context, "Received: " + action, Toast.LENGTH_SHORT).show();
    }
}
```

2. **Register the Receiver**
   - **Static Registration** (in `AndroidManifest.xml`):
   ```xml
   <receiver android:name=".MyBroadcastReceiver">
       <intent-filter>
           <action android:name="android.intent.action.BOOT_COMPLETED" />
       </intent-filter>
   </receiver>
   ```
   - **Dynamic Registration** (in Code):
   ```java
   IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
   MyBroadcastReceiver receiver = new MyBroadcastReceiver();
   registerReceiver(receiver, filter);
   ```

3. **Send a Broadcast**
```java
Intent intent = new Intent("com.example.CUSTOM_ACTION");
sendBroadcast(intent);
```

## Common Use Cases
- Monitoring battery status
- Detecting connectivity changes
- Listening for system boot events
- Custom application-level broadcasts

## Best Practices
1. **Avoid Memory Leaks**: Unregister dynamically registered receivers when not needed (e.g., in `onDestroy` of an activity).
2. **Security**: Use permissions to restrict who can send or receive broadcasts.
3. **Efficiency**: Minimize operations performed in the `onReceive` method.

## Sample Project
### Prerequisites:
- Android Studio
- Basic knowledge of Intents and Context

### Example Scenario:
Create an application that listens for a custom broadcast and shows a Toast message.

1. **Custom Action**: Define a custom action string in your app.
2. **Broadcast Sender**: Use a button to send the custom broadcast.
3. **Broadcast Receiver**: Implement a receiver to display a message upon receiving the broadcast.

## References
- [Android Developers Documentation - Broadcast Receivers](https://developer.android.com/guide/components/broadcasts)
- [AndroidManifest.xml](https://developer.android.com/guide/topics/manifest/manifest-intro)

---
Happy coding! 🎉
