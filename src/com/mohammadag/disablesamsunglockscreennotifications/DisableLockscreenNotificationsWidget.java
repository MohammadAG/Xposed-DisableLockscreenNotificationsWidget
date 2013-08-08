package com.mohammadag.disablesamsunglockscreennotifications;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class DisableLockscreenNotificationsWidget implements IXposedHookLoadPackage {

	@Override
	public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
		if (!lpparam.packageName.equals("android"))
			return;
		
		XposedHelpers.findAndHookMethod("com.android.internal.policy.impl.keyguard.sec.ContextualWidgetMonitor", lpparam.classLoader,
				"handleMissedEventUpdate", XC_MethodReplacement.DO_NOTHING);
	}
}
