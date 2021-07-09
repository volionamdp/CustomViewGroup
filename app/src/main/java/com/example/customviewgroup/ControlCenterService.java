//package com.example.customviewgroup;
//
//import android.annotation.SuppressLint;
//import android.app.AlarmManager;
//import android.app.Notification;
//import android.app.NotificationChannel;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.app.Service;
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.content.res.Resources;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Paint;
//import android.graphics.Point;
//import android.graphics.drawable.BitmapDrawable;
//import android.graphics.drawable.ColorDrawable;
//import android.graphics.drawable.Drawable;
//import android.graphics.drawable.GradientDrawable;
//import android.graphics.drawable.ShapeDrawable;
//import android.hardware.display.VirtualDisplay;
//import android.media.AudioAttributes;
//import android.media.Image;
//import android.media.ImageReader;
//import android.media.projection.MediaProjection;
//import android.media.projection.MediaProjectionManager;
//import android.net.Uri;
//import android.os.AsyncTask;
//import android.os.Build;
//import android.os.Handler;
//import android.os.IBinder;
//import android.os.SystemClock;
//import android.os.VibrationEffect;
//import android.os.Vibrator;
//import android.provider.Settings;
//import android.support.v7.widget.AppCompatImageView;
//import android.text.TextUtils;
//import android.util.DisplayMetrics;
//import android.view.GestureDetector;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.WindowManager;
//import com.luutinhit.activity.RatingActivity;
//import com.luutinhit.controlcenter.R;
//import com.luutinhit.customui.ActionView;
//import com.luutinhit.intro.SplashActivity;
//import defpackage.ali;
//import defpackage.amg;
//import defpackage.de;
//import java.lang.ref.WeakReference;
//import java.lang.reflect.Field;
//import java.nio.ByteBuffer;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class ControlCenterService extends Service implements ali.a, amg.a, View.OnTouchListener {
//    public static int a = 0;
//    public static Intent b = null;
//    /* access modifiers changed from: private */
//    public static String c = "ControlCenterService";
//    private int A;
//    private int B;
//    private int C;
//    private int D;
//    private boolean E = false;
//    /* access modifiers changed from: private */
//    public Vibrator F;
//    private boolean G = false;
//    private boolean H = false;
//    private boolean I = false;
//    private boolean J = false;
//    private boolean K = false;
//    private MediaProjection L = null;
//    private VirtualDisplay M = null;
//    private MediaProjectionManager N = null;
//    private ImageReader O;
//    private int P;
//    private int Q;
//    private int R;
//    private NotificationManager S;
//    private GestureDetector T;
//    private int U = 0;
//    private int V = 3;
//    private float W = 0.0f;
//    private float X = 0.0f;
//    private float Y = 0.0f;
//    private float Z = 0.0f;
//    private float aa = 0.0f;
//    private float ab = 0.0f;
//    private float ac = 1.0f;
//    private GestureDetector.OnGestureListener ad = new GestureDetector.SimpleOnGestureListener() {
//        public final boolean onDown(MotionEvent motionEvent) {
//            ControlCenterService.j(ControlCenterService.this);
//            String unused = ControlCenterService.c;
//            new Object[1][0] = Boolean.valueOf(ControlCenterService.this.q);
//            if (ControlCenterService.this.m != null && !ControlCenterService.this.q) {
//                ControlCenterService.this.a(false);
//            }
//            return true;
//        }
//
//        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
//            String unused = ControlCenterService.c;
//            if (ControlCenterService.this.m == null || ControlCenterService.this.m.g) {
//                return false;
//            }
//            ControlCenterService.this.C();
//            ControlCenterService.this.m.setControlViewScrolling(true);
//            return true;
//        }
//
//        public final boolean onSingleTapUp(MotionEvent motionEvent) {
//            String unused = ControlCenterService.c;
//            ControlCenterService.this.l();
//            return true;
//        }
//    };
//    private final int d = 0;
//    private final int e = 1;
//    private final int f = 2;
//    private final int g = 3;
//    /* access modifiers changed from: private */
//    public Context h;
//    /* access modifiers changed from: private */
//    public Resources i;
//    /* access modifiers changed from: private */
//    public WindowManager j;
//    private LayoutInflater k;
//    private int l = 2005;
//    /* access modifiers changed from: private */
//    public ali m;
//    /* access modifiers changed from: private */
//    public AppCompatImageView n;
//    private WindowManager.LayoutParams o;
//    /* access modifiers changed from: private */
//    public WindowManager.LayoutParams p;
//    /* access modifiers changed from: private */
//    public boolean q = false;
//    private ActionView r;
//    private WindowManager.LayoutParams s;
//    private amg t;
//    private int u = 3;
//    private int v;
//    private int w;
//    private float x;
//    private float y;
//    private int z;
//
//    class a extends AsyncTask<Void, Void, Bitmap> {
//        a() {
//            String unused = ControlCenterService.c;
//        }
//
//        /* access modifiers changed from: protected */
//        public final /* synthetic */ Object doInBackground(Object[] objArr) {
//            return ControlCenterService.this.G();
//        }
//
//        /* access modifiers changed from: protected */
//        public final /* synthetic */ void onPostExecute(Object obj) {
//            Bitmap bitmap = (Bitmap) obj;
//            super.onPostExecute(bitmap);
//            if (bitmap == null) {
//                ControlCenterService.this.D();
//            } else if (ControlCenterService.this.m != null) {
//                new c(ControlCenterService.this.n, ControlCenterService.this.m, ControlCenterService.this.i, (byte) 0).execute(new Bitmap[]{bitmap});
//            }
//        }
//    }
//
//    class b extends AsyncTask<Void, Void, Drawable> {
//        private int b = 3;
//        private float c = 0.02f;
//
//        b() {
//        }
//
//        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
//            r1 = defpackage.amt.a((r1 = ((android.graphics.drawable.BitmapDrawable) r0).getBitmap()), r4.c, r4.b);
//         */
//        /* Code decompiled incorrectly, please refer to instructions dump. */
//        private Drawable a() {
//            /*
//                r4 = this;
//                com.luutinhit.service.ControlCenterService r0 = com.luutinhit.service.ControlCenterService.this     // Catch:{ Throwable -> 0x002f }
//                android.content.Context r0 = r0.h     // Catch:{ Throwable -> 0x002f }
//                android.app.WallpaperManager r0 = android.app.WallpaperManager.getInstance(r0)     // Catch:{ Throwable -> 0x002f }
//                android.graphics.drawable.Drawable r0 = r0.getDrawable()     // Catch:{ Throwable -> 0x002f }
//                if (r0 == 0) goto L_0x002e
//                r1 = r0
//                android.graphics.drawable.BitmapDrawable r1 = (android.graphics.drawable.BitmapDrawable) r1     // Catch:{ Throwable -> 0x002f }
//                android.graphics.Bitmap r1 = r1.getBitmap()     // Catch:{ Throwable -> 0x002f }
//                if (r1 == 0) goto L_0x002e
//                float r2 = r4.c     // Catch:{ Throwable -> 0x002f }
//                int r3 = r4.b     // Catch:{ Throwable -> 0x002f }
//                android.graphics.Bitmap r1 = defpackage.amt.a(r1, r2, r3)     // Catch:{ Throwable -> 0x002f }
//                if (r1 == 0) goto L_0x002e
//                android.graphics.drawable.BitmapDrawable r0 = new android.graphics.drawable.BitmapDrawable     // Catch:{ Throwable -> 0x002f }
//                com.luutinhit.service.ControlCenterService r2 = com.luutinhit.service.ControlCenterService.this     // Catch:{ Throwable -> 0x002f }
//                android.content.res.Resources r2 = r2.i     // Catch:{ Throwable -> 0x002f }
//                r0.<init>(r2, r1)     // Catch:{ Throwable -> 0x002f }
//            L_0x002e:
//                return r0
//            L_0x002f:
//                r0 = move-exception
//                java.lang.String unused = com.luutinhit.service.ControlCenterService.c
//                r1 = 1
//                java.lang.Object[] r1 = new java.lang.Object[r1]
//                r2 = 0
//                java.lang.String r0 = r0.getMessage()
//                r1[r2] = r0
//                r0 = 0
//                return r0
//            */
//            throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.service.ControlCenterService.b.a():android.graphics.drawable.Drawable");
//        }
//
//        /* access modifiers changed from: protected */
//        public final /* synthetic */ Object doInBackground(Object[] objArr) {
//            return a();
//        }
//
//        /* access modifiers changed from: protected */
//        public final /* synthetic */ void onPostExecute(Object obj) {
//            Drawable drawable = (Drawable) obj;
//            String unused = ControlCenterService.c;
//            boolean z = true;
//            Object[] objArr = new Object[1];
//            if (drawable == null) {
//                z = false;
//            }
//            objArr[0] = Boolean.valueOf(z);
//            if (drawable == null || ControlCenterService.this.m == null) {
//                ControlCenterService.this.D();
//            } else if (Build.VERSION.SDK_INT >= 21) {
//                drawable.setAlpha(0);
//                ControlCenterService.this.m.setBackground(drawable);
//            } else {
//                ControlCenterService.this.n.setLayerType(2, (Paint) null);
//                ControlCenterService.this.n.setBackground(drawable);
//            }
//        }
//    }
//
//    static class c extends AsyncTask<Bitmap, Void, BitmapDrawable> {
//        private WeakReference<AppCompatImageView> a;
//        private WeakReference<ali> b;
//        private WeakReference<Resources> c;
//        private int d;
//        private float e;
//
//        private c(AppCompatImageView appCompatImageView, ali ali, Resources resources) {
//            this.d = 5;
//            this.e = 0.3f;
//            this.a = new WeakReference<>(appCompatImageView);
//            this.b = new WeakReference<>(ali);
//            this.c = new WeakReference<>(resources);
//        }
//
//        /* synthetic */ c(AppCompatImageView appCompatImageView, ali ali, Resources resources, byte b2) {
//            this(appCompatImageView, ali, resources);
//        }
//
//        /* access modifiers changed from: private */
//        /* renamed from: a */
//        public BitmapDrawable doInBackground(Bitmap... bitmapArr) {
//            Bitmap a2;
//            Bitmap bitmap = bitmapArr[0];
//            try {
//                if (this.c == null || this.c.get() == null || bitmap == null || (a2 = amt.a(bitmap, this.e, this.d)) == null) {
//                    return null;
//                }
//                return new BitmapDrawable((Resources) this.c.get(), a2);
//            } catch (Throwable th) {
//                String unused = ControlCenterService.c;
//                new Object[1][0] = th.getMessage();
//                return null;
//            }
//        }
//
//        /* access modifiers changed from: protected */
//        public final /* synthetic */ void onPostExecute(Object obj) {
//            BitmapDrawable bitmapDrawable = (BitmapDrawable) obj;
//            String unused = ControlCenterService.c;
//            if (bitmapDrawable == null || this.b == null || this.b.get() == null) {
//                if (this.b != null && this.b.get() != null) {
//                    if (Build.VERSION.SDK_INT >= 21) {
//                        ((ali) this.b.get()).setBackgroundResource(R.color.background_transparent);
//                    } else {
//                        ((AppCompatImageView) this.a.get()).setBackgroundResource(R.color.background_transparent);
//                    }
//                }
//            } else if (Build.VERSION.SDK_INT >= 21) {
//                bitmapDrawable.setAlpha(0);
//                ((ali) this.b.get()).setBackground(bitmapDrawable);
//            } else {
//                ((AppCompatImageView) this.a.get()).setLayerType(2, (Paint) null);
//                ((AppCompatImageView) this.a.get()).setBackground(bitmapDrawable);
//            }
//        }
//    }
//
//    private boolean A() {
//        try {
//            if (this.F.semIsHapticSupported()) {
//                this.F.semVibrate(50025, -1, (AudioAttributes) null, Vibrator.SemMagnitudeTypes.TYPE_TOUCH);
//                return true;
//            }
//        } catch (Throwable th) {
//            new Object[1][0] = th.getMessage();
//        }
//        return false;
//    }
//
//    private boolean B() {
//        try {
//            if (Build.VERSION.SDK_INT >= 17) {
//                Point point = new Point();
//                Point point2 = new Point();
//                DisplayMetrics displayMetrics = new DisplayMetrics();
//                this.j.getDefaultDisplay().getRealMetrics(displayMetrics);
//                point.x = displayMetrics.widthPixels;
//                point.y = displayMetrics.heightPixels;
//                this.j.getDefaultDisplay().getSize(point2);
//                if (point.y > point2.y || point.x > point2.x) {
//                    return true;
//                }
//                int identifier = this.i.getIdentifier("config_showNavigationBar", "bool", "android");
//                return identifier > 0 && this.i.getBoolean(identifier);
//            }
//            int identifier2 = this.i.getIdentifier("config_showNavigationBar", "bool", "android");
//            return identifier2 > 0 && this.i.getBoolean(identifier2);
//        } catch (Throwable unused) {
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void C() {
//        if (Build.VERSION.SDK_INT < 21) {
//            try {
//                if (!(this.j == null || this.n == null || this.p == null)) {
//                    this.j.addView(this.n, this.p);
//                }
//            } catch (Throwable th) {
//                new Object[1][0] = th.getMessage();
//            }
//        }
//        switch (b("preference_background")) {
//            case 0:
//                D();
//                return;
//            case 1:
//                new b().execute(new Void[0]);
//                return;
//            case 2:
//                if (Build.VERSION.SDK_INT < 21) {
//                    this.n.setBackgroundResource(R.drawable.default_background);
//                    return;
//                } else {
//                    this.m.setBackgroundResource(R.drawable.default_background);
//                    return;
//                }
//            case 3:
//                if (u() || !a(this.o)) {
//                    new a().execute(new Void[0]);
//                    return;
//                }
//                return;
//            default:
//                return;
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void D() {
//        if (Build.VERSION.SDK_INT < 21) {
//            if (this.n != null) {
//                this.n.setBackgroundResource(R.color.background_transparent);
//            }
//        } else if (this.m != null) {
//            this.m.setBackgroundResource(R.color.background_transparent);
//        }
//    }
//
//    private void E() {
//        try {
//            if (Build.VERSION.SDK_INT >= 21) {
//                if (this.O != null) {
//                    this.O.close();
//                    this.O = null;
//                }
//                if (this.P <= 0 || this.Q <= 0 || this.R <= 0) {
//                    this.P = a(this.j).widthPixels / 10;
//                    this.Q = a(this.j).heightPixels / 10;
//                    this.R = (int) this.i.getDisplayMetrics().density;
//                }
//                this.O = ImageReader.newInstance(this.P, this.Q, 1, 2);
//            }
//        } catch (Throwable th) {
//            new Object[1][0] = th.getMessage();
//        }
//    }
//
//    private void F() {
//        try {
//            if (Build.VERSION.SDK_INT >= 21 && this.N == null) {
//                this.P = a(this.j).widthPixels / 10;
//                this.Q = a(this.j).heightPixels / 10;
//                this.R = (int) this.i.getDisplayMetrics().density;
//                this.N = (MediaProjectionManager) getSystemService("media_projection");
//            }
//        } catch (Throwable th) {
//            new Object[1][0] = th.getMessage();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public Bitmap G() {
//        try {
//            if (Build.VERSION.SDK_INT >= 21) {
//                if (this.L == null) {
//                    if (Build.VERSION.SDK_INT >= 21 && this.L == null) {
//                        if (this.N == null) {
//                            this.N = (MediaProjectionManager) getSystemService("media_projection");
//                        }
//                        if (!(this.N == null || b == null)) {
//                            this.L = this.N.getMediaProjection(a, b);
//                        }
//                    }
//                }
//                new Object[1][0] = Boolean.valueOf(this.O != null);
//                if (this.O == null) {
//                    E();
//                }
//                Image image = null;
//                if (this.O != null) {
//                    new Object[1][0] = Boolean.valueOf(this.L != null);
//                    Object[] objArr = {Integer.valueOf(this.P), Integer.valueOf(this.Q), Integer.valueOf(this.R)};
//                    this.M = this.L.createVirtualDisplay("ScreenCapture", this.P, this.Q, this.R, 16, this.O.getSurface(), (VirtualDisplay.Callback) null, (Handler) null);
//                    image = this.O.acquireLatestImage();
//                    if (image == null) {
//                        this.O.acquireNextImage();
//                    }
//                    if (image == null) {
//                        Thread.sleep(68);
//                        image = this.O.acquireLatestImage();
//                        if (image == null) {
//                            this.O.acquireNextImage();
//                        }
//                        if (image == null) {
//                            Thread.sleep(36);
//                            image = this.O.acquireLatestImage();
//                            if (image == null) {
//                                this.O.acquireNextImage();
//                            }
//                        }
//                    }
//                }
//                new Object[1][0] = Boolean.valueOf(image != null);
//                if (image != null) {
//                    Image.Plane[] planes = image.getPlanes();
//                    ByteBuffer buffer = planes[0].getBuffer();
//                    int pixelStride = planes[0].getPixelStride();
//                    Bitmap createBitmap = Bitmap.createBitmap(this.P + ((planes[0].getRowStride() - (this.P * pixelStride)) / pixelStride), this.Q, Bitmap.Config.ARGB_8888);
//                    createBitmap.copyPixelsFromBuffer(buffer);
//                    Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, this.P, this.Q);
//                    image.close();
//                    if (createBitmap2 != null) {
//                        I();
//                        H();
//                        return createBitmap2;
//                    }
//                } else {
//                    I();
//                    H();
//                }
//            }
//        } catch (Throwable th) {
//            new Object[1][0] = th.getMessage();
//        }
//        I();
//        H();
//        return BitmapFactory.decodeResource(getResources(), R.drawable.default_background);
//    }
//
//    private void H() {
//        try {
//            if (Build.VERSION.SDK_INT >= 21 && this.L != null) {
//                this.L.stop();
//                this.L = null;
//            }
//        } catch (Throwable th) {
//            new Object[1][0] = th.getMessage();
//        }
//    }
//
//    private void I() {
//        if (Build.VERSION.SDK_INT >= 21 && this.M != null) {
//            this.M.release();
//            this.M = null;
//        }
//    }
//
//    private void J() {
//        String string = getString(R.string.app_name);
//        NotificationChannel notificationChannel = new NotificationChannel("ControlCenterService", "Service Notification", 1);
//        notificationChannel.setDescription(string);
//        notificationChannel.setShowBadge(false);
//        notificationChannel.setLockscreenVisibility(-1);
//        this.S.createNotificationChannel(notificationChannel);
//    }
//
//    private int a(String str, int i2) {
//        try {
//            int i3 = this.t.getInt(str, i2);
//            Object[] objArr = {str, Integer.valueOf(i3)};
//            return i3;
//        } catch (Throwable unused) {
//            return i2;
//        }
//    }
//
//    private static DisplayMetrics a(WindowManager windowManager) {
//        DisplayMetrics displayMetrics = new DisplayMetrics();
//        if (Build.VERSION.SDK_INT >= 21) {
//            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
//        }
//        return displayMetrics;
//    }
//
//    private void a(float f2) {
//        try {
//            if (this.o != null && this.H) {
//                new Object[1][0] = Float.valueOf(f2);
//                if (f2 == 0.0f && b(this.o)) {
//                    this.o.flags &= -3;
//                    b(this.o);
//                    this.o.dimAmount = 0.0f;
//                } else if (a(this.o)) {
//                    this.o.flags |= 2;
//                    this.o.dimAmount = f2;
//                    c(this.o);
//                }
//            }
//        } catch (Throwable th) {
//            new Object[1][0] = th.getMessage();
//        }
//    }
//
//    private void a(int i2, Drawable drawable) {
//        try {
//            if (drawable instanceof ShapeDrawable) {
//                ((ShapeDrawable) drawable.mutate()).getPaint().setColor(i2);
//            } else if (drawable instanceof GradientDrawable) {
//                GradientDrawable gradientDrawable = (GradientDrawable) drawable.mutate();
//                gradientDrawable.setColor(i2);
//                gradientDrawable.setStroke(1, ec.b(-16777216, 255 - a("action_view_alpha_choice", 145)));
//            } else if (drawable instanceof ColorDrawable) {
//                ((ColorDrawable) drawable.mutate()).setColor(i2);
//            }
//        } catch (Throwable th) {
//            new Object[1][0] = th.getMessage();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void a(boolean z2) {
//        try {
//            m();
//            if (o()) {
//                p();
//            } else if (this.j != null && this.m != null && this.o != null) {
//                a(0.3f);
//                this.j.addView(this.m, this.o);
//                this.q = true;
//                if (z2) {
//                    C();
//                    this.m.b();
//                }
//                this.U++;
//            }
//        } catch (Throwable unused) {
//            p();
//        }
//    }
//
//    private boolean a(WindowManager.LayoutParams layoutParams) {
//        try {
//            if (q()) {
//                this.o.semAddExtensionFlags(64);
//                return true;
//            }
//            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("samsungFlags");
//            declaredField.setInt(layoutParams, 64 | declaredField.getInt(layoutParams));
//            return true;
//        } catch (Throwable unused) {
//            return false;
//        }
//    }
//
//    private boolean a(String str, boolean z2) {
//        try {
//            boolean z3 = this.t.getBoolean(str, z2);
//            Object[] objArr = {str, Boolean.valueOf(z3)};
//            return z3;
//        } catch (Throwable unused) {
//            return true;
//        }
//    }
//
//    private int b(String str) {
//        try {
//            return Integer.parseInt(this.t.getString(str, "2"));
//        } catch (Throwable th) {
//            new Object[1][0] = th.getMessage();
//            return 2;
//        }
//    }
//
//    private void b(boolean z2) {
//        de.d a2;
//        String string;
//        new Object[1][0] = Boolean.valueOf(z2);
//        this.S = (NotificationManager) getSystemService("notification");
//        if (z2) {
//            try {
//                if (Build.VERSION.SDK_INT >= 26) {
//                    J();
//                }
//                Intent intent = new Intent(this, SplashActivity.class);
//                int i2 = Build.VERSION.SDK_INT;
//                intent.setFlags(268468224);
//                PendingIntent activity = PendingIntent.getActivity(this, 66666666, intent, 0);
//                Intent intent2 = new Intent(this, ControlCenterService.class);
//                intent2.setAction("ACTION_STOP_SERVICE");
//                if (Build.VERSION.SDK_INT >= 16) {
//                    intent2.setFlags(268435456);
//                }
//                PendingIntent service = PendingIntent.getService(this, 686868, intent2, 134217728);
//                if (Build.VERSION.SDK_INT >= 21) {
//                    de.d a3 = new de.d(this, "ControlCenterService").a(System.currentTimeMillis());
//                    a3.j = -2;
//                    a3.b(2);
//                    de.d a4 = a3.a();
//                    a4.C = 1;
//                    a2 = a4.a((CharSequence) getString(R.string.app_name)).b((CharSequence) getString(R.string.notification_stop_application_content)).a((int) R.drawable.ic_control_center);
//                    a2.d = activity;
//                    string = getString(R.string.stop);
//                } else if (Build.VERSION.SDK_INT >= 16) {
//                    de.d a5 = new de.d(this, "ControlCenterService").a(System.currentTimeMillis());
//                    a5.j = -2;
//                    a5.b(2);
//                    a2 = a5.a().a((CharSequence) getString(R.string.app_name)).b((CharSequence) getString(R.string.notification_stop_application_content)).a((int) R.drawable.ic_control_center);
//                    a2.d = activity;
//                    string = getString(R.string.stop);
//                } else {
//                    de.d a6 = new de.d(this, "ControlCenterService").a(System.currentTimeMillis());
//                    a6.b(2);
//                    a2 = a6.a().a((CharSequence) getString(R.string.app_name)).b((CharSequence) getString(R.string.notification_stop_application_content)).a((int) R.drawable.ic_control_center);
//                    a2.d = activity;
//                    string = getString(R.string.stop);
//                }
//                Notification b2 = a2.a(17301552, string, service).b();
//                if (b2 != null) {
//                    startForeground(686868, b2);
//                    this.K = true;
//                }
//            } catch (Throwable unused) {
//            }
//        } else {
//            stopForeground(true);
//            if (this.S != null) {
//                this.S.cancel(686868);
//            }
//        }
//    }
//
//    private boolean b(WindowManager.LayoutParams layoutParams) {
//        try {
//            if (q()) {
//                this.o.semClearExtensionFlags(64);
//                return true;
//            }
//            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("samsungFlags");
//            declaredField.setInt(layoutParams, declaredField.getInt(layoutParams) & -65);
//            return true;
//        } catch (Throwable unused) {
//            return false;
//        }
//    }
//
//    private boolean b(String str, boolean z2) {
//        try {
//            Object[] objArr = {str, Boolean.valueOf(z2)};
//            SharedPreferences.Editor edit = this.t.edit();
//            edit.putBoolean(str, z2);
//            edit.apply();
//            return true;
//        } catch (Throwable unused) {
//            return false;
//        }
//    }
//
//    private ArrayList<String> c(String str) {
//        try {
//            String[] split = TextUtils.split(this.t.getString(str, TextUtils.join("‚‗‚", new ArrayList())), "‚‗‚");
//            new Object[1][0] = Arrays.toString(split);
//            return new ArrayList<>(Arrays.asList(split));
//        } catch (Throwable unused) {
//            return null;
//        }
//    }
//
//    private void c(WindowManager.LayoutParams layoutParams) {
//        try {
//            if (q()) {
//                this.o.semAddPrivateFlags(131072);
//                return;
//            }
//            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("privateFlags");
//            declaredField.setInt(layoutParams, 131072 | declaredField.getInt(layoutParams));
//        } catch (Throwable unused) {
//        }
//    }
//
//    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
//        r0.inflate(r1, r2);
//     */
//    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
//        r3.r.setOnTouchListener(r3);
//     */
//    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
//        a(a("action_view_color_choice", 1848222582), r3.r.getChildAt(0).getBackground());
//     */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    private void e() {
//        /*
//            r3 = this;
//            r3.h()     // Catch:{ Throwable -> 0x0085 }
//            android.view.WindowManager$LayoutParams r0 = r3.s     // Catch:{ Throwable -> 0x0085 }
//            if (r0 != 0) goto L_0x000a
//            r3.g()     // Catch:{ Throwable -> 0x0085 }
//        L_0x000a:
//            com.luutinhit.customui.ActionView r0 = r3.r     // Catch:{ Throwable -> 0x0085 }
//            if (r0 != 0) goto L_0x006e
//            com.luutinhit.customui.ActionView r0 = new com.luutinhit.customui.ActionView     // Catch:{ Throwable -> 0x0085 }
//            android.content.Context r1 = r3.h     // Catch:{ Throwable -> 0x0085 }
//            r0.<init>(r1)     // Catch:{ Throwable -> 0x0085 }
//            r3.r = r0     // Catch:{ Throwable -> 0x0085 }
//            com.luutinhit.customui.ActionView r0 = r3.r     // Catch:{ Throwable -> 0x0085 }
//            int r1 = r3.z     // Catch:{ Throwable -> 0x0085 }
//            r0.setActionViewSize(r1)     // Catch:{ Throwable -> 0x0085 }
//            int r0 = r3.u     // Catch:{ Throwable -> 0x0085 }
//            switch(r0) {
//                case 0: goto L_0x003f;
//                case 1: goto L_0x0037;
//                case 2: goto L_0x002f;
//                case 3: goto L_0x0024;
//                default: goto L_0x0023;
//            }     // Catch:{ Throwable -> 0x0085 }
//        L_0x0023:
//            goto L_0x0047
//        L_0x0024:
//            android.view.LayoutInflater r0 = r3.k     // Catch:{ Throwable -> 0x0085 }
//            r1 = 2131427355(0x7f0b001b, float:1.8476324E38)
//            com.luutinhit.customui.ActionView r2 = r3.r     // Catch:{ Throwable -> 0x0085 }
//        L_0x002b:
//            r0.inflate(r1, r2)     // Catch:{ Throwable -> 0x0085 }
//            goto L_0x0047
//        L_0x002f:
//            android.view.LayoutInflater r0 = r3.k     // Catch:{ Throwable -> 0x0085 }
//            r1 = 2131427357(0x7f0b001d, float:1.8476328E38)
//            com.luutinhit.customui.ActionView r2 = r3.r     // Catch:{ Throwable -> 0x0085 }
//            goto L_0x002b
//        L_0x0037:
//            android.view.LayoutInflater r0 = r3.k     // Catch:{ Throwable -> 0x0085 }
//            r1 = 2131427356(0x7f0b001c, float:1.8476326E38)
//            com.luutinhit.customui.ActionView r2 = r3.r     // Catch:{ Throwable -> 0x0085 }
//            goto L_0x002b
//        L_0x003f:
//            android.view.LayoutInflater r0 = r3.k     // Catch:{ Throwable -> 0x0085 }
//            r1 = 2131427358(0x7f0b001e, float:1.847633E38)
//            com.luutinhit.customui.ActionView r2 = r3.r     // Catch:{ Throwable -> 0x0085 }
//            goto L_0x002b
//        L_0x0047:
//            com.luutinhit.customui.ActionView r0 = r3.r     // Catch:{ Throwable -> 0x0085 }
//            r0.setOnTouchListener(r3)     // Catch:{ Throwable -> 0x0085 }
//            r0 = 0
//            java.lang.String r1 = "action_view_color_choice"
//            r2 = 1848222582(0x6e29a376, float:1.3125145E28)
//            int r1 = r3.a((java.lang.String) r1, (int) r2)     // Catch:{ Throwable -> 0x0064 }
//            com.luutinhit.customui.ActionView r2 = r3.r     // Catch:{ Throwable -> 0x0064 }
//            android.view.View r2 = r2.getChildAt(r0)     // Catch:{ Throwable -> 0x0064 }
//            android.graphics.drawable.Drawable r2 = r2.getBackground()     // Catch:{ Throwable -> 0x0064 }
//            r3.a((int) r1, (android.graphics.drawable.Drawable) r2)     // Catch:{ Throwable -> 0x0064 }
//            goto L_0x006e
//        L_0x0064:
//            r1 = move-exception
//            r2 = 1
//            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x0085 }
//            java.lang.String r1 = r1.getMessage()     // Catch:{ Throwable -> 0x0085 }
//            r2[r0] = r1     // Catch:{ Throwable -> 0x0085 }
//        L_0x006e:
//            boolean r0 = r3.o()     // Catch:{ Throwable -> 0x0085 }
//            if (r0 == 0) goto L_0x007b
//            r3.p()     // Catch:{ Throwable -> 0x0085 }
//            r0 = 0
//            r3.r = r0     // Catch:{ Throwable -> 0x0085 }
//            return
//        L_0x007b:
//            android.view.WindowManager r0 = r3.j     // Catch:{ Throwable -> 0x0085 }
//            com.luutinhit.customui.ActionView r1 = r3.r     // Catch:{ Throwable -> 0x0085 }
//            android.view.WindowManager$LayoutParams r2 = r3.s     // Catch:{ Throwable -> 0x0085 }
//            r0.addView(r1, r2)     // Catch:{ Throwable -> 0x0085 }
//            return
//        L_0x0085:
//            r3.p()
//            return
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.service.ControlCenterService.e():void");
//    }
//
//    private void f() {
//        new Object[1][0] = Integer.valueOf(this.z);
//        try {
//            this.r.setActionViewSize(this.z);
//            switch (this.u) {
//                case 0:
//                case 3:
//                    this.s.width = this.z;
//                    break;
//                case 1:
//                case 2:
//                    this.s.height = this.z;
//                    break;
//            }
//            if (o()) {
//                p();
//            } else if (this.r != null && this.s != null) {
//                this.j.updateViewLayout(this.r, this.s);
//            }
//        } catch (Throwable th) {
//            new Object[1][0] = th.getMessage();
//            p();
//        }
//    }
//
//    @SuppressLint({"RtlHardcoded"})
//    private void g() {
//        int i2;
//        WindowManager.LayoutParams layoutParams;
//        Object[] objArr = {Integer.valueOf(this.u), Boolean.valueOf(this.I)};
//        this.l = this.J ? 2007 : (this.I || Build.VERSION.SDK_INT >= 25 || w()) ? Build.VERSION.SDK_INT >= 26 ? 2038 : 2010 : 2005;
//        new Object[1][0] = Integer.valueOf(this.l);
//        int i3 = (!B() || this.J) ? 8519976 : 40;
//        if (this.s == null) {
//            this.s = new WindowManager.LayoutParams(-2, -2, this.l, i3, -3);
//            switch (this.u) {
//                case 0:
//                    this.s.width = this.z;
//                    this.s.gravity = 49;
//                    layoutParams = this.s;
//                    i2 = R.style.ActionViewAnimationTop;
//                    break;
//                case 1:
//                    this.s.height = this.z;
//                    this.s.gravity = 19;
//                    layoutParams = this.s;
//                    i2 = R.style.ActionViewAnimationLeft;
//                    break;
//                case 2:
//                    this.s.height = this.z;
//                    this.s.gravity = 21;
//                    layoutParams = this.s;
//                    i2 = R.style.ActionViewAnimationRight;
//                    break;
//                case 3:
//                    this.s.width = this.z;
//                    this.s.gravity = 81;
//                    layoutParams = this.s;
//                    i2 = R.style.ActionViewAnimationBottom;
//                    break;
//            }
//            layoutParams.windowAnimations = i2;
//        }
//        z();
//    }
//
//    private void h() {
//        try {
//            this.j.removeViewImmediate(this.r);
//            this.r = null;
//            this.s = null;
//        } catch (Throwable th) {
//            new Object[1][0] = th.getMessage();
//        }
//    }
//
//    private void i() {
//        try {
//            if (this.h == null || this.h.getPackageName().contains("luutinhit")) {
//                if (this.o == null) {
//                    j();
//                }
//                if (this.m == null) {
//                    this.m = new ali(this.h, this.u);
//                    this.m.setOnBackKeyPressListener(this);
//                    this.m.a(this.B, this.C);
//                    this.m.setUseSamsungFrameworkToBlur(this.H);
//                }
//            }
//        } catch (Throwable unused) {
//        }
//    }
//
//    private void j() {
//        this.l = (this.I || Build.VERSION.SDK_INT >= 25 || w()) ? Build.VERSION.SDK_INT >= 26 ? 2038 : 2010 : 2005;
//        if (this.o == null) {
//            this.o = new WindowManager.LayoutParams(this.B, this.C, 0, 0, this.l, 1824, -2);
//            this.o.gravity = 8388659;
//            this.o.windowAnimations = R.style.ControlPanelAnimationFade;
//            if (Build.VERSION.SDK_INT >= 19 && B()) {
//                this.o.systemUiVisibility = 5895;
//            }
//            x();
//        }
//        if (Build.VERSION.SDK_INT < 21 && this.p == null) {
//            k();
//        }
//    }
//
//    static /* synthetic */ void j(ControlCenterService controlCenterService) {
//        try {
//            if (controlCenterService.G && !controlCenterService.A()) {
//                if (controlCenterService.G) {
//                    new Thread(new Runnable() {
//                        public final void run() {
//                            try {
//                                String unused = ControlCenterService.c;
//                                if (Build.VERSION.SDK_INT >= 26) {
//                                    ControlCenterService.this.F.vibrate(VibrationEffect.createOneShot(38, -1));
//                                } else {
//                                    ControlCenterService.this.F.vibrate(38);
//                                }
//                            } catch (Throwable th) {
//                                String unused2 = ControlCenterService.c;
//                                new Object[1][0] = th.getMessage();
//                            }
//                        }
//                    }).start();
//                }
//            }
//        } catch (Throwable th) {
//            new Object[1][0] = th.getMessage();
//        }
//    }
//
//    private void k() {
//        this.l = (this.I || Build.VERSION.SDK_INT >= 25 || w()) ? Build.VERSION.SDK_INT >= 26 ? 2038 : 2010 : 2005;
//        if (this.p == null) {
//            this.p = new WindowManager.LayoutParams(-1, -1, this.l, 1312, -2);
//            this.p.gravity = 8388659;
//            this.p.windowAnimations = R.style.ControlPanelAnimationFade;
//            if (Build.VERSION.SDK_INT >= 19 && B()) {
//                this.p.systemUiVisibility = 5894;
//            }
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void l() {
//        try {
//            this.j.removeViewImmediate(this.m);
//            this.q = false;
//            if (Build.VERSION.SDK_INT < 21) {
//                if (this.n != null) {
//                    this.n.setBackgroundResource(0);
//                }
//                this.j.removeViewImmediate(this.n);
//            }
//        } catch (Throwable th) {
//            try {
//                new Object[1][0] = th.getMessage();
//            } catch (Throwable th2) {
//                new Object[1][0] = th2.getMessage();
//                return;
//            }
//        }
//        if (this.r != null) {
//            this.r.animate().alpha(1.0f).setDuration(150).start();
//        }
//    }
//
//    private void m() {
//        if (this.r != null) {
//            this.r.animate().alpha(0.5f).setDuration(150).start();
//        }
//    }
//
//    private void n() {
//        try {
//            Intent intent = new Intent(this.h, RatingActivity.class);
//            intent.setFlags(268435456);
//            startActivity(intent);
//        } catch (Throwable th) {
//            new Object[1][0] = th.getMessage();
//        }
//    }
//
//    private boolean o() {
//        return Build.VERSION.SDK_INT >= 25 && !Settings.canDrawOverlays(this);
//    }
//
//    private void p() {
//        try {
//            if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this)) {
//                Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName()));
//                intent.addFlags(805306368);
//                intent.addFlags(268435456);
//                startActivity(intent);
//            }
//        } catch (Throwable th) {
//            new Object[1][0] = th.getMessage();
//        }
//    }
//
//    private static boolean q() {
//        try {
//            return Build.VERSION.class.getField("SEM_INT") != null;
//        } catch (Throwable unused) {
//            return false;
//        }
//    }
//
//    private void r() {
//        try {
//            h();
//            l();
//            Intent intent = new Intent(this.h, getClass());
//            intent.setPackage(getPackageName());
//            PendingIntent service = PendingIntent.getService(this.h, 1, intent, 1073741824);
//            AlarmManager alarmManager = (AlarmManager) this.h.getSystemService("alarm");
//            if (alarmManager != null) {
//                alarmManager.set(3, SystemClock.elapsedRealtime() + 1000, service);
//            }
//        } catch (Throwable th) {
//            new Object[1][0] = th.getMessage();
//        }
//    }
//
//    private void s() {
//        if (this.j != null) {
//            this.B = a(this.j).widthPixels;
//            this.C = a(this.j).heightPixels;
//            if (this.o != null) {
//                this.o.width = this.B;
//                this.o.height = this.C;
//                if (this.q) {
//                    this.j.updateViewLayout(this.m, this.o);
//                }
//            }
//            if (this.m != null) {
//                this.m.a(this.B, this.C);
//            }
//        }
//    }
//
//    private boolean t() {
//        ArrayList<String> c2 = c("favorite_action_choose");
//        return (c2 == null || c2.size() == 0 || !c2.contains("com.luutinhit.controlcenter.control_record")) ? false : true;
//    }
//
//    private boolean u() {
//        return v() && !amu.a();
//    }
//
//    private boolean v() {
//        try {
//            return b("preference_background") == 3;
//        } catch (Throwable unused) {
//            return false;
//        }
//    }
//
//    private static boolean w() {
//        try {
//            return Build.MANUFACTURER.toLowerCase().contains("oppo");
//        } catch (Throwable unused) {
//            return false;
//        }
//    }
//
//    private void x() {
//        this.H = amu.a() && v();
//        if (this.m != null) {
//            this.m.setUseSamsungFrameworkToBlur(this.H);
//        }
//    }
//
//    private int y() {
//        try {
//            return this.A + this.t.getInt("action_view_size", 50);
//        } catch (Throwable unused) {
//            return this.i.getDimensionPixelSize(R.dimen.action_view_size);
//        }
//    }
//
//    private void z() {
//        try {
//            if (this.s != null) {
//                this.s.x = a("x_location", 0);
//                this.s.y = a("y_location", 0);
//            }
//        } catch (Throwable th) {
//            new Object[1][0] = th.getMessage();
//        }
//    }
//
//    public final void a() {
//        try {
//            if (this.H) {
//                a(0.3f);
//                this.j.updateViewLayout(this.m, this.o);
//            }
//        } catch (Throwable th) {
//            new Object[1][0] = th.getMessage();
//        }
//    }
//
//    /* JADX WARNING: Can't wrap try/catch for region: R(5:54|55|56|57|151) */
//    /* JADX WARNING: Can't wrap try/catch for region: R(6:(2:68|(1:70)(5:71|73|74|75|76))|72|73|74|75|76) */
//    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01ba, code lost:
//        r8.inflate(r0, r2);
//     */
//    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01d6, code lost:
//        r7.r.setOnTouchListener(r7);
//        r7.r.setActionViewSize(r7.z);
//     */
//    /* JADX WARNING: Code restructure failed: missing block: B:122:?, code lost:
//        a(a("action_view_color_choice", 1848222582), r7.r.getChildAt(0).getBackground());
//     */
//    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x00d1 */
//    /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x011a */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public final void a(String r8) {
//        /*
//            r7 = this;
//            if (r8 == 0) goto L_0x0249
//            r0 = -1
//            int r1 = r8.hashCode()
//            r2 = 3
//            r3 = 2
//            r4 = 1
//            r5 = 0
//            switch(r1) {
//                case -1091287984: goto L_0x006c;
//                case -621643397: goto L_0x0061;
//                case -31069550: goto L_0x0057;
//                case 451310959: goto L_0x004d;
//                case 493152018: goto L_0x0042;
//                case 689999758: goto L_0x0038;
//                case 747804969: goto L_0x002e;
//                case 836014551: goto L_0x0024;
//                case 1470442186: goto L_0x001a;
//                case 2045156077: goto L_0x0010;
//                default: goto L_0x000e;
//            }
//        L_0x000e:
//            goto L_0x0075
//        L_0x0010:
//            java.lang.String r1 = "show_notification"
//            boolean r1 = r8.equals(r1)
//            if (r1 == 0) goto L_0x0075
//            r0 = 7
//            goto L_0x0075
//        L_0x001a:
//            java.lang.String r1 = "hide_on_keyboard"
//            boolean r1 = r8.equals(r1)
//            if (r1 == 0) goto L_0x0075
//            r0 = 6
//            goto L_0x0075
//        L_0x0024:
//            java.lang.String r1 = "switchEnable"
//            boolean r1 = r8.equals(r1)
//            if (r1 == 0) goto L_0x0075
//            r0 = 0
//            goto L_0x0075
//        L_0x002e:
//            java.lang.String r1 = "position"
//            boolean r1 = r8.equals(r1)
//            if (r1 == 0) goto L_0x0075
//            r0 = 1
//            goto L_0x0075
//        L_0x0038:
//            java.lang.String r1 = "action_view_color_choice"
//            boolean r1 = r8.equals(r1)
//            if (r1 == 0) goto L_0x0075
//            r0 = 3
//            goto L_0x0075
//        L_0x0042:
//            java.lang.String r1 = "preference_background"
//            boolean r1 = r8.equals(r1)
//            if (r1 == 0) goto L_0x0075
//            r0 = 8
//            goto L_0x0075
//        L_0x004d:
//            java.lang.String r1 = "vibrate"
//            boolean r1 = r8.equals(r1)
//            if (r1 == 0) goto L_0x0075
//            r0 = 4
//            goto L_0x0075
//        L_0x0057:
//            java.lang.String r1 = "action_view_size"
//            boolean r1 = r8.equals(r1)
//            if (r1 == 0) goto L_0x0075
//            r0 = 2
//            goto L_0x0075
//        L_0x0061:
//            java.lang.String r1 = "number_show_rate_dialog"
//            boolean r1 = r8.equals(r1)
//            if (r1 == 0) goto L_0x0075
//            r0 = 9
//            goto L_0x0075
//        L_0x006c:
//            java.lang.String r1 = "overlay"
//            boolean r1 = r8.equals(r1)
//            if (r1 == 0) goto L_0x0075
//            r0 = 5
//        L_0x0075:
//            r1 = 1848222582(0x6e29a376, float:1.3125145E28)
//            r6 = 0
//            switch(r0) {
//                case 0: goto L_0x0232;
//                case 1: goto L_0x0174;
//                case 2: goto L_0x015b;
//                case 3: goto L_0x0149;
//                case 4: goto L_0x0142;
//                case 5: goto L_0x00df;
//                case 6: goto L_0x00c0;
//                case 7: goto L_0x00b8;
//                case 8: goto L_0x0086;
//                case 9: goto L_0x007e;
//                default: goto L_0x007c;
//            }
//        L_0x007c:
//            goto L_0x0249
//        L_0x007e:
//            int r8 = r7.a((java.lang.String) r8, (int) r2)
//            r7.V = r8
//            goto L_0x0249
//        L_0x0086:
//            boolean r8 = defpackage.amu.a()
//            if (r8 == 0) goto L_0x00ae
//            java.lang.Object[] r8 = new java.lang.Object[r4]
//            boolean r0 = r7.v()
//            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
//            r8[r5] = r0
//            r7.x()
//            boolean r8 = r7.v()
//            if (r8 == 0) goto L_0x00a8
//            r8 = 1050253722(0x3e99999a, float:0.3)
//            r7.a((float) r8)
//            return
//        L_0x00a8:
//            r7.o = r6
//            r7.j()
//            return
//        L_0x00ae:
//            boolean r8 = r7.u()
//            if (r8 != 0) goto L_0x0249
//            r7.H()
//            return
//        L_0x00b8:
//            boolean r8 = r7.a((java.lang.String) r8, (boolean) r4)
//            r7.b((boolean) r8)
//            return
//        L_0x00c0:
//            boolean r8 = r7.a((java.lang.String) r8, (boolean) r5)
//            r7.J = r8
//            android.view.WindowManager$LayoutParams r8 = r7.s     // Catch:{ Throwable -> 0x00d5 }
//            if (r8 == 0) goto L_0x00d4
//            android.view.WindowManager r8 = r7.j     // Catch:{ Throwable -> 0x00d1 }
//            com.luutinhit.customui.ActionView r0 = r7.r     // Catch:{ Throwable -> 0x00d1 }
//            r8.removeView(r0)     // Catch:{ Throwable -> 0x00d1 }
//        L_0x00d1:
//            r7.e()     // Catch:{ Throwable -> 0x00d5 }
//        L_0x00d4:
//            return
//        L_0x00d5:
//            r8 = move-exception
//            java.lang.Object[] r0 = new java.lang.Object[r4]
//            java.lang.String r8 = r8.getMessage()
//            r0[r5] = r8
//            return
//        L_0x00df:
//            boolean r8 = r7.a((java.lang.String) r8, (boolean) r5)
//            r7.I = r8
//            boolean r8 = r7.I
//            android.view.WindowManager$LayoutParams r0 = r7.s     // Catch:{ Throwable -> 0x0138 }
//            r1 = 2005(0x7d5, float:2.81E-42)
//            r2 = 2010(0x7da, float:2.817E-42)
//            r3 = 25
//            if (r0 == 0) goto L_0x011d
//            if (r8 != 0) goto L_0x0103
//            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x0138 }
//            if (r0 >= r3) goto L_0x0103
//            boolean r0 = w()     // Catch:{ Throwable -> 0x0138 }
//            if (r0 == 0) goto L_0x00fe
//            goto L_0x0103
//        L_0x00fe:
//            android.view.WindowManager$LayoutParams r0 = r7.s     // Catch:{ Throwable -> 0x0138 }
//            r0.type = r1     // Catch:{ Throwable -> 0x0138 }
//            goto L_0x0107
//        L_0x0103:
//            android.view.WindowManager$LayoutParams r0 = r7.s     // Catch:{ Throwable -> 0x0138 }
//            r0.type = r2     // Catch:{ Throwable -> 0x0138 }
//        L_0x0107:
//            android.view.WindowManager r0 = r7.j     // Catch:{ Throwable -> 0x011a }
//            com.luutinhit.customui.ActionView r6 = r7.r     // Catch:{ Throwable -> 0x011a }
//            r0.removeView(r6)     // Catch:{ Throwable -> 0x011a }
//            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch:{ Throwable -> 0x011a }
//            android.view.WindowManager$LayoutParams r6 = r7.s     // Catch:{ Throwable -> 0x011a }
//            int r6 = r6.type     // Catch:{ Throwable -> 0x011a }
//            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Throwable -> 0x011a }
//            r0[r5] = r6     // Catch:{ Throwable -> 0x011a }
//        L_0x011a:
//            r7.e()     // Catch:{ Throwable -> 0x0138 }
//        L_0x011d:
//            android.view.WindowManager$LayoutParams r0 = r7.o     // Catch:{ Throwable -> 0x0138 }
//            if (r0 == 0) goto L_0x0137
//            if (r8 != 0) goto L_0x0133
//            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x0138 }
//            if (r8 >= r3) goto L_0x0133
//            boolean r8 = w()     // Catch:{ Throwable -> 0x0138 }
//            if (r8 == 0) goto L_0x012e
//            goto L_0x0133
//        L_0x012e:
//            android.view.WindowManager$LayoutParams r8 = r7.o     // Catch:{ Throwable -> 0x0138 }
//            r8.type = r1     // Catch:{ Throwable -> 0x0138 }
//            goto L_0x0137
//        L_0x0133:
//            android.view.WindowManager$LayoutParams r8 = r7.o     // Catch:{ Throwable -> 0x0138 }
//            r8.type = r2     // Catch:{ Throwable -> 0x0138 }
//        L_0x0137:
//            return
//        L_0x0138:
//            r8 = move-exception
//            java.lang.Object[] r0 = new java.lang.Object[r4]
//            java.lang.String r8 = r8.getMessage()
//            r0[r5] = r8
//            return
//        L_0x0142:
//            boolean r8 = r7.a((java.lang.String) r8, (boolean) r4)
//            r7.G = r8
//            return
//        L_0x0149:
//            int r8 = r7.a((java.lang.String) r8, (int) r1)
//            com.luutinhit.customui.ActionView r0 = r7.r
//            android.view.View r0 = r0.getChildAt(r5)
//            android.graphics.drawable.Drawable r0 = r0.getBackground()
//            r7.a((int) r8, (android.graphics.drawable.Drawable) r0)
//            return
//        L_0x015b:
//            r0 = 100
//            int r8 = r7.a((java.lang.String) r8, (int) r0)     // Catch:{ Throwable -> 0x016a }
//            int r0 = r7.A     // Catch:{ Throwable -> 0x016a }
//            int r0 = r0 + r8
//            r7.z = r0     // Catch:{ Throwable -> 0x016a }
//            r7.f()     // Catch:{ Throwable -> 0x016a }
//            return
//        L_0x016a:
//            r8 = move-exception
//            java.lang.Object[] r0 = new java.lang.Object[r4]
//            java.lang.String r8 = r8.getMessage()
//            r0[r5] = r8
//            return
//        L_0x0174:
//            int r8 = r7.a((java.lang.String) r8, (int) r3)     // Catch:{ Throwable -> 0x0228 }
//            r7.u = r8     // Catch:{ Throwable -> 0x0228 }
//            amg r8 = r7.t     // Catch:{ Throwable -> 0x0191 }
//            android.content.SharedPreferences$Editor r8 = r8.edit()     // Catch:{ Throwable -> 0x0191 }
//            java.lang.String r0 = "x_location"
//            r8.putInt(r0, r5)     // Catch:{ Throwable -> 0x0191 }
//            r8.apply()     // Catch:{ Throwable -> 0x0191 }
//            java.lang.String r0 = "y_location"
//            r8.putInt(r0, r5)     // Catch:{ Throwable -> 0x0191 }
//            r8.apply()     // Catch:{ Throwable -> 0x0191 }
//            goto L_0x019a
//        L_0x0191:
//            r8 = move-exception
//            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch:{ Throwable -> 0x0228 }
//            java.lang.String r8 = r8.getMessage()     // Catch:{ Throwable -> 0x0228 }
//            r0[r5] = r8     // Catch:{ Throwable -> 0x0228 }
//        L_0x019a:
//            r7.s = r6     // Catch:{ Throwable -> 0x021b }
//            r7.g()     // Catch:{ Throwable -> 0x021b }
//            r7.o = r6     // Catch:{ Throwable -> 0x021b }
//            r7.j()     // Catch:{ Throwable -> 0x021b }
//            com.luutinhit.customui.ActionView r8 = r7.r     // Catch:{ Throwable -> 0x021b }
//            if (r8 == 0) goto L_0x01ff
//            com.luutinhit.customui.ActionView r8 = r7.r     // Catch:{ Throwable -> 0x021b }
//            r8.removeAllViews()     // Catch:{ Throwable -> 0x021b }
//            int r8 = r7.u     // Catch:{ Throwable -> 0x021b }
//            switch(r8) {
//                case 0: goto L_0x01ce;
//                case 1: goto L_0x01c6;
//                case 2: goto L_0x01be;
//                case 3: goto L_0x01b3;
//                default: goto L_0x01b2;
//            }     // Catch:{ Throwable -> 0x021b }
//        L_0x01b2:
//            goto L_0x01d6
//        L_0x01b3:
//            android.view.LayoutInflater r8 = r7.k     // Catch:{ Throwable -> 0x021b }
//            r0 = 2131427355(0x7f0b001b, float:1.8476324E38)
//            com.luutinhit.customui.ActionView r2 = r7.r     // Catch:{ Throwable -> 0x021b }
//        L_0x01ba:
//            r8.inflate(r0, r2)     // Catch:{ Throwable -> 0x021b }
//            goto L_0x01d6
//        L_0x01be:
//            android.view.LayoutInflater r8 = r7.k     // Catch:{ Throwable -> 0x021b }
//            r0 = 2131427357(0x7f0b001d, float:1.8476328E38)
//            com.luutinhit.customui.ActionView r2 = r7.r     // Catch:{ Throwable -> 0x021b }
//            goto L_0x01ba
//        L_0x01c6:
//            android.view.LayoutInflater r8 = r7.k     // Catch:{ Throwable -> 0x021b }
//            r0 = 2131427356(0x7f0b001c, float:1.8476326E38)
//            com.luutinhit.customui.ActionView r2 = r7.r     // Catch:{ Throwable -> 0x021b }
//            goto L_0x01ba
//        L_0x01ce:
//            android.view.LayoutInflater r8 = r7.k     // Catch:{ Throwable -> 0x021b }
//            r0 = 2131427358(0x7f0b001e, float:1.847633E38)
//            com.luutinhit.customui.ActionView r2 = r7.r     // Catch:{ Throwable -> 0x021b }
//            goto L_0x01ba
//        L_0x01d6:
//            com.luutinhit.customui.ActionView r8 = r7.r     // Catch:{ Throwable -> 0x021b }
//            r8.setOnTouchListener(r7)     // Catch:{ Throwable -> 0x021b }
//            com.luutinhit.customui.ActionView r8 = r7.r     // Catch:{ Throwable -> 0x021b }
//            int r0 = r7.z     // Catch:{ Throwable -> 0x021b }
//            r8.setActionViewSize(r0)     // Catch:{ Throwable -> 0x021b }
//            java.lang.String r8 = "action_view_color_choice"
//            int r8 = r7.a((java.lang.String) r8, (int) r1)     // Catch:{ Throwable -> 0x01f6 }
//            com.luutinhit.customui.ActionView r0 = r7.r     // Catch:{ Throwable -> 0x01f6 }
//            android.view.View r0 = r0.getChildAt(r5)     // Catch:{ Throwable -> 0x01f6 }
//            android.graphics.drawable.Drawable r0 = r0.getBackground()     // Catch:{ Throwable -> 0x01f6 }
//            r7.a((int) r8, (android.graphics.drawable.Drawable) r0)     // Catch:{ Throwable -> 0x01f6 }
//            goto L_0x01ff
//        L_0x01f6:
//            r8 = move-exception
//            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch:{ Throwable -> 0x021b }
//            java.lang.String r8 = r8.getMessage()     // Catch:{ Throwable -> 0x021b }
//            r0[r5] = r8     // Catch:{ Throwable -> 0x021b }
//        L_0x01ff:
//            boolean r8 = r7.o()     // Catch:{ Throwable -> 0x021b }
//            if (r8 == 0) goto L_0x0209
//            r7.p()     // Catch:{ Throwable -> 0x021b }
//            return
//        L_0x0209:
//            com.luutinhit.customui.ActionView r8 = r7.r     // Catch:{ Throwable -> 0x021b }
//            if (r8 == 0) goto L_0x021a
//            android.view.WindowManager$LayoutParams r8 = r7.s     // Catch:{ Throwable -> 0x021b }
//            if (r8 == 0) goto L_0x021a
//            android.view.WindowManager r8 = r7.j     // Catch:{ Throwable -> 0x021b }
//            com.luutinhit.customui.ActionView r0 = r7.r     // Catch:{ Throwable -> 0x021b }
//            android.view.WindowManager$LayoutParams r1 = r7.s     // Catch:{ Throwable -> 0x021b }
//            r8.updateViewLayout(r0, r1)     // Catch:{ Throwable -> 0x021b }
//        L_0x021a:
//            return
//        L_0x021b:
//            r8 = move-exception
//            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch:{ Throwable -> 0x0228 }
//            java.lang.String r8 = r8.getMessage()     // Catch:{ Throwable -> 0x0228 }
//            r0[r5] = r8     // Catch:{ Throwable -> 0x0228 }
//            r7.p()     // Catch:{ Throwable -> 0x0228 }
//            return
//        L_0x0228:
//            r8 = move-exception
//            java.lang.Object[] r0 = new java.lang.Object[r4]
//            java.lang.String r8 = r8.getMessage()
//            r0[r5] = r8
//            return
//        L_0x0232:
//            boolean r8 = r7.a((java.lang.String) r8, (boolean) r4)
//            if (r8 == 0) goto L_0x0249
//            int r8 = android.os.Build.VERSION.SDK_INT
//            r0 = 26
//            if (r8 < r0) goto L_0x0246
//            boolean r8 = r7.K
//            if (r8 == 0) goto L_0x0249
//            r7.stopSelf()
//            return
//        L_0x0246:
//            r7.stopSelf()
//        L_0x0249:
//            return
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.service.ControlCenterService.a(java.lang.String):void");
//    }
//
//    public final void b() {
//        if (this.H) {
//            a(0.0f);
//            this.j.updateViewLayout(this.m, this.o);
//        }
//    }
//
//    public final void c() {
//        l();
//        new Object[1][0] = Integer.valueOf(this.U);
//        if (this.U == this.V && !a("not_show_exit_dialog", false)) {
//            n();
//            this.U = 0;
//        }
//    }
//
//    public IBinder onBind(Intent intent) {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
//
//    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public void onConfigurationChanged(android.content.res.Configuration r10) {
//        /*
//            r9 = this;
//            super.onConfigurationChanged(r10)
//            r9.s()     // Catch:{ Throwable -> 0x004d }
//            int r10 = android.os.Build.VERSION.SDK_INT     // Catch:{  }
//            r0 = 21
//            if (r10 < r0) goto L_0x004d
//            android.view.WindowManager r10 = r9.j     // Catch:{  }
//            android.util.DisplayMetrics r10 = a((android.view.WindowManager) r10)     // Catch:{  }
//            int r10 = r10.widthPixels     // Catch:{  }
//            int r10 = r10 / 10
//            r9.P = r10     // Catch:{  }
//            android.view.WindowManager r10 = r9.j     // Catch:{  }
//            android.util.DisplayMetrics r10 = a((android.view.WindowManager) r10)     // Catch:{  }
//            int r10 = r10.heightPixels     // Catch:{  }
//            int r10 = r10 / 10
//            r9.Q = r10     // Catch:{  }
//            r9.E()     // Catch:{  }
//            android.hardware.display.VirtualDisplay r10 = r9.M     // Catch:{  }
//            if (r10 == 0) goto L_0x0033
//            android.hardware.display.VirtualDisplay r10 = r9.M     // Catch:{  }
//            r10.release()     // Catch:{  }
//            r10 = 0
//            r9.M = r10     // Catch:{  }
//        L_0x0033:
//            android.media.projection.MediaProjection r0 = r9.L     // Catch:{  }
//            java.lang.String r1 = "ScreenCapture"
//            int r2 = r9.P     // Catch:{  }
//            int r3 = r9.Q     // Catch:{  }
//            int r4 = r9.R     // Catch:{  }
//            r5 = 16
//            android.media.ImageReader r10 = r9.O     // Catch:{  }
//            android.view.Surface r6 = r10.getSurface()     // Catch:{  }
//            r7 = 0
//            r8 = 0
//            android.hardware.display.VirtualDisplay r10 = r0.createVirtualDisplay(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{  }
//            r9.M = r10     // Catch:{  }
//        L_0x004d:
//            return
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.service.ControlCenterService.onConfigurationChanged(android.content.res.Configuration):void");
//    }
//
//    public void onCreate() {
//        int i2;
//        super.onCreate();
//        this.i = getResources();
//        this.h = getApplicationContext();
//        this.F = (Vibrator) getSystemService("vibrator");
//        this.j = (WindowManager) getSystemService("window");
//        this.k = (LayoutInflater) getSystemService("layout_inflater");
//        this.t = amf.a(this.h);
//        this.t.a(this);
//        this.T = new GestureDetector(this.h, this.ad);
//        this.K = false;
//        b(a("show_notification", true));
//        if (Build.VERSION.SDK_INT < 21) {
//            this.n = new AppCompatImageView(this.h);
//        }
//        s();
//        int identifier = this.i.getIdentifier("status_bar_height", "dimen", "android");
//        if (identifier > 0) {
//            i2 = this.i.getDimensionPixelSize(identifier);
//        } else {
//            i2 = (int) Math.ceil((double) (((float) (Build.VERSION.SDK_INT >= 23 ? 24 : 25)) * this.i.getDisplayMetrics().density));
//        }
//        this.D = i2;
//        this.A = this.i.getDimensionPixelSize(R.dimen.action_view_size);
//        this.z = y();
//        this.u = a("position", B() ? 2 : 3);
//        this.G = a("vibrate", true);
//        this.I = a("overlay", false);
//        this.V = a("number_show_rate_dialog", 3);
//        e();
//        i();
//    }
//
//    public void onDestroy() {
//        try {
//            if (a("switchEnable", true)) {
//                r();
//            } else {
//                h();
//                l();
//                H();
//                this.K = false;
//            }
//        } catch (Throwable th) {
//            new Object[1][0] = th.getMessage();
//        }
//        super.onDestroy();
//    }
//
//    public void onLowMemory() {
//        r();
//    }
//
//    /* JADX WARNING: Can't fix incorrect switch cases order */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public int onStartCommand(Intent r5, int r6, int r7) {
//        /*
//            r4 = this;
//            r6 = 1
//            if (r5 == 0) goto L_0x0135
//            java.lang.String r7 = r5.getAction()
//            r0 = 21
//            r1 = 0
//            if (r7 == 0) goto L_0x00f5
//            int r2 = r7.hashCode()
//            r3 = -1
//            switch(r2) {
//                case -1023568191: goto L_0x005b;
//                case -893681601: goto L_0x0051;
//                case -476650600: goto L_0x0047;
//                case 937545949: goto L_0x003d;
//                case 1262567630: goto L_0x0033;
//                case 1305250938: goto L_0x0029;
//                case 1546547406: goto L_0x001f;
//                case 1793462762: goto L_0x0015;
//                default: goto L_0x0014;
//            }
//        L_0x0014:
//            goto L_0x0065
//        L_0x0015:
//            java.lang.String r2 = "ACTION_FORCE_UPDATE_COLOR"
//            boolean r7 = r7.equals(r2)
//            if (r7 == 0) goto L_0x0065
//            r7 = 4
//            goto L_0x0066
//        L_0x001f:
//            java.lang.String r2 = "ACTION_DO_SETTINGS"
//            boolean r7 = r7.equals(r2)
//            if (r7 == 0) goto L_0x0065
//            r7 = 0
//            goto L_0x0066
//        L_0x0029:
//            java.lang.String r2 = "ACTION_FORCE_UPDATE_SIZE"
//            boolean r7 = r7.equals(r2)
//            if (r7 == 0) goto L_0x0065
//            r7 = 5
//            goto L_0x0066
//        L_0x0033:
//            java.lang.String r2 = "ACTION_SETUP_PROJECT"
//            boolean r7 = r7.equals(r2)
//            if (r7 == 0) goto L_0x0065
//            r7 = 6
//            goto L_0x0066
//        L_0x003d:
//            java.lang.String r2 = "ACTION_FORCE_HIDE_CONTROL"
//            boolean r7 = r7.equals(r2)
//            if (r7 == 0) goto L_0x0065
//            r7 = 3
//            goto L_0x0066
//        L_0x0047:
//            java.lang.String r2 = "ACTION_FORCE_SHOW_CONTROL"
//            boolean r7 = r7.equals(r2)
//            if (r7 == 0) goto L_0x0065
//            r7 = 2
//            goto L_0x0066
//        L_0x0051:
//            java.lang.String r2 = "ACTION_CANCEL_SETTINGS"
//            boolean r7 = r7.equals(r2)
//            if (r7 == 0) goto L_0x0065
//            r7 = 1
//            goto L_0x0066
//        L_0x005b:
//            java.lang.String r2 = "ACTION_STOP_SERVICE"
//            boolean r7 = r7.equals(r2)
//            if (r7 == 0) goto L_0x0065
//            r7 = 7
//            goto L_0x0066
//        L_0x0065:
//            r7 = -1
//        L_0x0066:
//            switch(r7) {
//                case 0: goto L_0x00f2;
//                case 1: goto L_0x00ef;
//                case 2: goto L_0x00de;
//                case 3: goto L_0x00da;
//                case 4: goto L_0x00b6;
//                case 5: goto L_0x00a8;
//                case 6: goto L_0x007f;
//                case 7: goto L_0x006b;
//                default: goto L_0x0069;
//            }
//        L_0x0069:
//            goto L_0x00f5
//        L_0x006b:
//            java.lang.String r5 = "switchEnable"
//            r4.b(r5, r1)
//            int r5 = android.os.Build.VERSION.SDK_INT
//            r7 = 26
//            if (r5 < r7) goto L_0x007a
//            boolean r5 = r4.K
//            if (r5 == 0) goto L_0x00f5
//        L_0x007a:
//            r4.stopSelf()
//            goto L_0x00f5
//        L_0x007f:
//            int r7 = android.os.Build.VERSION.SDK_INT
//            if (r7 < r0) goto L_0x00f5
//            java.lang.String r7 = "resultCode"
//            int r7 = r5.getIntExtra(r7, r3)
//            a = r7
//            android.content.Intent r7 = new android.content.Intent
//            r7.<init>()
//            b = r7
//            android.os.Bundle r7 = r5.getExtras()
//            if (r7 == 0) goto L_0x00a1
//            android.content.Intent r7 = b
//            android.os.Bundle r5 = r5.getExtras()
//            r7.putExtras(r5)
//        L_0x00a1:
//            r4.F()
//            r4.E()
//            goto L_0x00f5
//        L_0x00a8:
//            r4.f()     // Catch:{ Throwable -> 0x00ac }
//            goto L_0x00f5
//        L_0x00ac:
//            r5 = move-exception
//            java.lang.Object[] r7 = new java.lang.Object[r6]
//            java.lang.String r5 = r5.getMessage()
//            r7[r1] = r5
//            goto L_0x00f5
//        L_0x00b6:
//            r4.f()     // Catch:{ Throwable -> 0x00d0 }
//            java.lang.String r5 = "action_view_color_choice"
//            r7 = 1848222582(0x6e29a376, float:1.3125145E28)
//            int r5 = r4.a((java.lang.String) r5, (int) r7)     // Catch:{ Throwable -> 0x00d0 }
//            com.luutinhit.customui.ActionView r7 = r4.r     // Catch:{ Throwable -> 0x00d0 }
//            android.view.View r7 = r7.getChildAt(r1)     // Catch:{ Throwable -> 0x00d0 }
//            android.graphics.drawable.Drawable r7 = r7.getBackground()     // Catch:{ Throwable -> 0x00d0 }
//            r4.a((int) r5, (android.graphics.drawable.Drawable) r7)     // Catch:{ Throwable -> 0x00d0 }
//            goto L_0x00f5
//        L_0x00d0:
//            r5 = move-exception
//            java.lang.Object[] r7 = new java.lang.Object[r6]
//            java.lang.String r5 = r5.getMessage()
//            r7[r1] = r5
//            goto L_0x00f5
//        L_0x00da:
//            r4.c()
//            return r6
//        L_0x00de:
//            java.lang.String r5 = "switchEnable"
//            boolean r5 = r4.a((java.lang.String) r5, (boolean) r6)
//            if (r5 != 0) goto L_0x00eb
//            java.lang.String r5 = "switchEnable"
//            r4.b(r5, r6)
//        L_0x00eb:
//            r4.a((boolean) r6)
//            return r6
//        L_0x00ef:
//            r4.E = r1
//            return r6
//        L_0x00f2:
//            r4.E = r6
//            return r6
//        L_0x00f5:
//            java.lang.Object[] r5 = new java.lang.Object[r6]
//            boolean r7 = r4.t()
//            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
//            r5[r1] = r7
//            int r5 = android.os.Build.VERSION.SDK_INT
//            if (r5 < r0) goto L_0x0135
//            boolean r5 = r4.u()
//            if (r5 != 0) goto L_0x0111
//            boolean r5 = r4.t()
//            if (r5 == 0) goto L_0x0135
//        L_0x0111:
//            android.content.Intent r5 = b
//            if (r5 != 0) goto L_0x0135
//            android.content.Intent r5 = new android.content.Intent     // Catch:{ Throwable -> 0x0129 }
//            android.content.Context r7 = r4.h     // Catch:{ Throwable -> 0x0129 }
//            java.lang.Class<com.luutinhit.activity.ProjectionActivity> r0 = com.luutinhit.activity.ProjectionActivity.class
//            r5.<init>(r7, r0)     // Catch:{ Throwable -> 0x0129 }
//            r7 = 268435456(0x10000000, float:2.5243549E-29)
//            r5.setFlags(r7)     // Catch:{ Throwable -> 0x0129 }
//            android.content.Context r7 = r4.h     // Catch:{ Throwable -> 0x0129 }
//            r7.startActivity(r5)     // Catch:{ Throwable -> 0x0129 }
//            goto L_0x0132
//        L_0x0129:
//            r5 = move-exception
//            java.lang.Object[] r7 = new java.lang.Object[r6]
//            java.lang.String r5 = r5.getMessage()
//            r7[r1] = r5
//        L_0x0132:
//            r4.F()
//        L_0x0135:
//            com.luutinhit.customui.ActionView r5 = r4.r
//            if (r5 != 0) goto L_0x013f
//            r4.e()
//            r4.i()
//        L_0x013f:
//            return r6
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.service.ControlCenterService.onStartCommand(android.content.Intent, int, int):int");
//    }
//
//    public void onTaskRemoved(Intent intent) {
//        r();
//    }
//
//    /* JADX WARNING: Can't fix incorrect switch cases order */
//    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0291, code lost:
//        r13.updateViewLayout(r2, r3);
//     */
//    /* JADX WARNING: Code restructure failed: missing block: B:153:0x03ab, code lost:
//        r13.setFloatValues(r2);
//     */
//    /* JADX WARNING: Code restructure failed: missing block: B:61:0x017a, code lost:
//        r13.updateViewLayout(r2, r5);
//     */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public boolean onTouch(View r13, MotionEvent r14) {
//        /*
//            r12 = this;
//            r0 = 1
//            r1 = 0
//            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0543 }
//            java.lang.String r3 = "onTouch view = "
//            r2.<init>(r3)     // Catch:{ Throwable -> 0x0543 }
//            r2.append(r13)     // Catch:{ Throwable -> 0x0543 }
//            java.lang.String r3 = ", event = "
//            r2.append(r3)     // Catch:{ Throwable -> 0x0543 }
//            r2.append(r14)     // Catch:{ Throwable -> 0x0543 }
//            if (r14 == 0) goto L_0x0542
//            if (r13 != 0) goto L_0x001a
//            goto L_0x0542
//        L_0x001a:
//            boolean r2 = r12.E     // Catch:{ Throwable -> 0x0543 }
//            r3 = 2
//            if (r2 == 0) goto L_0x0104
//            android.view.ViewGroup$LayoutParams r13 = r13.getLayoutParams()     // Catch:{ Throwable -> 0x0543 }
//            android.view.WindowManager$LayoutParams r13 = (android.view.WindowManager.LayoutParams) r13     // Catch:{ Throwable -> 0x0543 }
//            r12.s = r13     // Catch:{ Throwable -> 0x0543 }
//            int r13 = r14.getAction()     // Catch:{ Throwable -> 0x0543 }
//            switch(r13) {
//                case 0: goto L_0x00e4;
//                case 1: goto L_0x0060;
//                case 2: goto L_0x0030;
//                default: goto L_0x002e;
//            }     // Catch:{ Throwable -> 0x0543 }
//        L_0x002e:
//            goto L_0x0103
//        L_0x0030:
//            int r13 = r12.u     // Catch:{ Throwable -> 0x0543 }
//            switch(r13) {
//                case 0: goto L_0x0046;
//                case 1: goto L_0x0036;
//                case 2: goto L_0x0036;
//                case 3: goto L_0x0046;
//                default: goto L_0x0035;
//            }     // Catch:{ Throwable -> 0x0543 }
//        L_0x0035:
//            goto L_0x0055
//        L_0x0036:
//            android.view.WindowManager$LayoutParams r13 = r12.s     // Catch:{ Throwable -> 0x0543 }
//            int r2 = r12.w     // Catch:{ Throwable -> 0x0543 }
//            float r14 = r14.getRawY()     // Catch:{ Throwable -> 0x0543 }
//            float r3 = r12.y     // Catch:{ Throwable -> 0x0543 }
//            float r14 = r14 - r3
//            int r14 = (int) r14     // Catch:{ Throwable -> 0x0543 }
//            int r2 = r2 + r14
//            r13.y = r2     // Catch:{ Throwable -> 0x0543 }
//            goto L_0x0055
//        L_0x0046:
//            android.view.WindowManager$LayoutParams r13 = r12.s     // Catch:{ Throwable -> 0x0543 }
//            int r2 = r12.v     // Catch:{ Throwable -> 0x0543 }
//            float r14 = r14.getRawX()     // Catch:{ Throwable -> 0x0543 }
//            float r3 = r12.x     // Catch:{ Throwable -> 0x0543 }
//            float r14 = r14 - r3
//            int r14 = (int) r14     // Catch:{ Throwable -> 0x0543 }
//            int r2 = r2 + r14
//            r13.x = r2     // Catch:{ Throwable -> 0x0543 }
//        L_0x0055:
//            android.view.WindowManager r13 = r12.j     // Catch:{ Throwable -> 0x0543 }
//            com.luutinhit.customui.ActionView r14 = r12.r     // Catch:{ Throwable -> 0x0543 }
//            android.view.WindowManager$LayoutParams r2 = r12.s     // Catch:{ Throwable -> 0x0543 }
//            r13.updateViewLayout(r14, r2)     // Catch:{ Throwable -> 0x0543 }
//            goto L_0x0103
//        L_0x0060:
//            int r13 = r12.u     // Catch:{ Throwable -> 0x0543 }
//            switch(r13) {
//                case 0: goto L_0x0095;
//                case 1: goto L_0x0066;
//                case 2: goto L_0x0066;
//                case 3: goto L_0x0095;
//                default: goto L_0x0065;
//            }     // Catch:{ Throwable -> 0x0543 }
//        L_0x0065:
//            goto L_0x00b7
//        L_0x0066:
//            android.view.WindowManager$LayoutParams r13 = r12.s     // Catch:{ Throwable -> 0x0543 }
//            int r13 = r13.y     // Catch:{ Throwable -> 0x0543 }
//            int r14 = r12.C     // Catch:{ Throwable -> 0x0543 }
//            int r2 = r12.D     // Catch:{ Throwable -> 0x0543 }
//            int r14 = r14 - r2
//            int r14 = r14 / r3
//            if (r13 <= r14) goto L_0x007c
//            android.view.WindowManager$LayoutParams r13 = r12.s     // Catch:{ Throwable -> 0x0543 }
//            int r14 = r12.C     // Catch:{ Throwable -> 0x0543 }
//            int r2 = r12.D     // Catch:{ Throwable -> 0x0543 }
//            int r14 = r14 - r2
//            int r14 = r14 / r3
//            r13.y = r14     // Catch:{ Throwable -> 0x0543 }
//        L_0x007c:
//            android.view.WindowManager$LayoutParams r13 = r12.s     // Catch:{ Throwable -> 0x0543 }
//            int r13 = r13.y     // Catch:{ Throwable -> 0x0543 }
//            int r14 = r12.C     // Catch:{ Throwable -> 0x0543 }
//            int r2 = r12.D     // Catch:{ Throwable -> 0x0543 }
//            int r14 = r14 - r2
//            int r14 = r14 / r3
//            int r14 = -r14
//            if (r13 >= r14) goto L_0x00b7
//            android.view.WindowManager$LayoutParams r13 = r12.s     // Catch:{ Throwable -> 0x0543 }
//            int r14 = r12.C     // Catch:{ Throwable -> 0x0543 }
//            int r2 = r12.D     // Catch:{ Throwable -> 0x0543 }
//            int r14 = r14 - r2
//            int r14 = r14 / r3
//            int r14 = -r14
//            r13.y = r14     // Catch:{ Throwable -> 0x0543 }
//            goto L_0x00b7
//        L_0x0095:
//            android.view.WindowManager$LayoutParams r13 = r12.s     // Catch:{ Throwable -> 0x0543 }
//            int r13 = r13.x     // Catch:{ Throwable -> 0x0543 }
//            int r14 = r12.B     // Catch:{ Throwable -> 0x0543 }
//            int r14 = r14 / r3
//            if (r13 <= r14) goto L_0x00a5
//            android.view.WindowManager$LayoutParams r13 = r12.s     // Catch:{ Throwable -> 0x0543 }
//            int r14 = r12.B     // Catch:{ Throwable -> 0x0543 }
//            int r14 = r14 / r3
//            r13.x = r14     // Catch:{ Throwable -> 0x0543 }
//        L_0x00a5:
//            android.view.WindowManager$LayoutParams r13 = r12.s     // Catch:{ Throwable -> 0x0543 }
//            int r13 = r13.x     // Catch:{ Throwable -> 0x0543 }
//            int r14 = r12.B     // Catch:{ Throwable -> 0x0543 }
//            int r14 = -r14
//            int r14 = r14 / r3
//            if (r13 >= r14) goto L_0x00b7
//            android.view.WindowManager$LayoutParams r13 = r12.s     // Catch:{ Throwable -> 0x0543 }
//            int r14 = r12.B     // Catch:{ Throwable -> 0x0543 }
//            int r14 = -r14
//            int r14 = r14 / r3
//            r13.x = r14     // Catch:{ Throwable -> 0x0543 }
//        L_0x00b7:
//            android.view.WindowManager$LayoutParams r13 = r12.s     // Catch:{ Throwable -> 0x00da }
//            if (r13 == 0) goto L_0x0103
//            amg r13 = r12.t     // Catch:{ Throwable -> 0x00da }
//            android.content.SharedPreferences$Editor r13 = r13.edit()     // Catch:{ Throwable -> 0x00da }
//            java.lang.String r14 = "x_location"
//            android.view.WindowManager$LayoutParams r2 = r12.s     // Catch:{ Throwable -> 0x00da }
//            int r2 = r2.x     // Catch:{ Throwable -> 0x00da }
//            r13.putInt(r14, r2)     // Catch:{ Throwable -> 0x00da }
//            r13.apply()     // Catch:{ Throwable -> 0x00da }
//            java.lang.String r14 = "y_location"
//            android.view.WindowManager$LayoutParams r2 = r12.s     // Catch:{ Throwable -> 0x00da }
//            int r2 = r2.y     // Catch:{ Throwable -> 0x00da }
//            r13.putInt(r14, r2)     // Catch:{ Throwable -> 0x00da }
//            r13.apply()     // Catch:{ Throwable -> 0x00da }
//            goto L_0x0103
//        L_0x00da:
//            r13 = move-exception
//            java.lang.Object[] r14 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x0543 }
//            java.lang.String r13 = r13.getMessage()     // Catch:{ Throwable -> 0x0543 }
//            r14[r1] = r13     // Catch:{ Throwable -> 0x0543 }
//            goto L_0x0103
//        L_0x00e4:
//            int r13 = r12.u     // Catch:{ Throwable -> 0x0543 }
//            switch(r13) {
//                case 0: goto L_0x00f7;
//                case 1: goto L_0x00ea;
//                case 2: goto L_0x00ea;
//                case 3: goto L_0x00f7;
//                default: goto L_0x00e9;
//            }     // Catch:{ Throwable -> 0x0543 }
//        L_0x00e9:
//            goto L_0x0103
//        L_0x00ea:
//            android.view.WindowManager$LayoutParams r13 = r12.s     // Catch:{ Throwable -> 0x0543 }
//            int r13 = r13.y     // Catch:{ Throwable -> 0x0543 }
//            r12.w = r13     // Catch:{ Throwable -> 0x0543 }
//            float r13 = r14.getRawY()     // Catch:{ Throwable -> 0x0543 }
//            r12.y = r13     // Catch:{ Throwable -> 0x0543 }
//            goto L_0x0103
//        L_0x00f7:
//            android.view.WindowManager$LayoutParams r13 = r12.s     // Catch:{ Throwable -> 0x0543 }
//            int r13 = r13.x     // Catch:{ Throwable -> 0x0543 }
//            r12.v = r13     // Catch:{ Throwable -> 0x0543 }
//            float r13 = r14.getRawX()     // Catch:{ Throwable -> 0x0543 }
//            r12.x = r13     // Catch:{ Throwable -> 0x0543 }
//        L_0x0103:
//            return r0
//        L_0x0104:
//            r13 = 4
//            java.lang.Object[] r13 = new java.lang.Object[r13]     // Catch:{ Throwable -> 0x0539 }
//            float r2 = r14.getX()     // Catch:{ Throwable -> 0x0539 }
//            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ Throwable -> 0x0539 }
//            r13[r1] = r2     // Catch:{ Throwable -> 0x0539 }
//            float r2 = r14.getY()     // Catch:{ Throwable -> 0x0539 }
//            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ Throwable -> 0x0539 }
//            r13[r0] = r2     // Catch:{ Throwable -> 0x0539 }
//            float r2 = r14.getRawX()     // Catch:{ Throwable -> 0x0539 }
//            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ Throwable -> 0x0539 }
//            r13[r3] = r2     // Catch:{ Throwable -> 0x0539 }
//            float r2 = r14.getRawY()     // Catch:{ Throwable -> 0x0539 }
//            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ Throwable -> 0x0539 }
//            r4 = 3
//            r13[r4] = r2     // Catch:{ Throwable -> 0x0539 }
//            android.view.GestureDetector r13 = r12.T     // Catch:{ Throwable -> 0x0539 }
//            if (r13 == 0) goto L_0x0139
//            android.view.GestureDetector r13 = r12.T     // Catch:{ Throwable -> 0x0539 }
//            r13.onTouchEvent(r14)     // Catch:{ Throwable -> 0x0539 }
//        L_0x0139:
//            boolean r13 = r12.H     // Catch:{ Throwable -> 0x0539 }
//            if (r13 == 0) goto L_0x01e5
//            int r13 = r14.getAction()     // Catch:{ Throwable -> 0x01dc }
//            if (r13 != r3) goto L_0x01e5
//            float r13 = r14.getRawX()     // Catch:{ Throwable -> 0x01dc }
//            r12.x = r13     // Catch:{ Throwable -> 0x01dc }
//            float r13 = r14.getRawY()     // Catch:{ Throwable -> 0x01dc }
//            r12.y = r13     // Catch:{ Throwable -> 0x01dc }
//            int r13 = r12.u     // Catch:{ Throwable -> 0x01dc }
//            r2 = 1050253722(0x3e99999a, float:0.3)
//            switch(r13) {
//                case 0: goto L_0x01be;
//                case 1: goto L_0x01a0;
//                case 2: goto L_0x017e;
//                case 3: goto L_0x0159;
//                default: goto L_0x0157;
//            }     // Catch:{ Throwable -> 0x01dc }
//        L_0x0157:
//            goto L_0x01e5
//        L_0x0159:
//            int r13 = r12.C     // Catch:{ Throwable -> 0x01dc }
//            float r13 = (float) r13     // Catch:{ Throwable -> 0x01dc }
//            float r5 = r12.y     // Catch:{ Throwable -> 0x01dc }
//            float r13 = r13 - r5
//            int r5 = r12.C     // Catch:{ Throwable -> 0x01dc }
//            float r5 = (float) r5     // Catch:{ Throwable -> 0x01dc }
//            float r13 = r13 / r5
//            float r13 = r13 * r2
//            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x01dc }
//            java.lang.Float r6 = java.lang.Float.valueOf(r13)     // Catch:{ Throwable -> 0x01dc }
//            r5[r1] = r6     // Catch:{ Throwable -> 0x01dc }
//            int r2 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
//            if (r2 > 0) goto L_0x01e5
//            r12.a((float) r13)     // Catch:{ Throwable -> 0x01dc }
//            android.view.WindowManager r13 = r12.j     // Catch:{ Throwable -> 0x01dc }
//            ali r2 = r12.m     // Catch:{ Throwable -> 0x01dc }
//            android.view.WindowManager$LayoutParams r5 = r12.o     // Catch:{ Throwable -> 0x01dc }
//        L_0x017a:
//            r13.updateViewLayout(r2, r5)     // Catch:{ Throwable -> 0x01dc }
//            goto L_0x01e5
//        L_0x017e:
//            int r13 = r12.B     // Catch:{ Throwable -> 0x01dc }
//            float r13 = (float) r13     // Catch:{ Throwable -> 0x01dc }
//            float r5 = r12.x     // Catch:{ Throwable -> 0x01dc }
//            float r13 = r13 - r5
//            int r5 = r12.B     // Catch:{ Throwable -> 0x01dc }
//            float r5 = (float) r5     // Catch:{ Throwable -> 0x01dc }
//            float r13 = r13 / r5
//            float r13 = r13 * r2
//            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x01dc }
//            java.lang.Float r6 = java.lang.Float.valueOf(r13)     // Catch:{ Throwable -> 0x01dc }
//            r5[r1] = r6     // Catch:{ Throwable -> 0x01dc }
//            int r2 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
//            if (r2 > 0) goto L_0x01e5
//            r12.a((float) r13)     // Catch:{ Throwable -> 0x01dc }
//            android.view.WindowManager r13 = r12.j     // Catch:{ Throwable -> 0x01dc }
//            ali r2 = r12.m     // Catch:{ Throwable -> 0x01dc }
//            android.view.WindowManager$LayoutParams r5 = r12.o     // Catch:{ Throwable -> 0x01dc }
//            goto L_0x017a
//        L_0x01a0:
//            float r13 = r12.x     // Catch:{ Throwable -> 0x01dc }
//            int r5 = r12.B     // Catch:{ Throwable -> 0x01dc }
//            float r5 = (float) r5     // Catch:{ Throwable -> 0x01dc }
//            float r13 = r13 / r5
//            float r13 = r13 * r2
//            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x01dc }
//            java.lang.Float r6 = java.lang.Float.valueOf(r13)     // Catch:{ Throwable -> 0x01dc }
//            r5[r1] = r6     // Catch:{ Throwable -> 0x01dc }
//            int r2 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
//            if (r2 > 0) goto L_0x01e5
//            r12.a((float) r13)     // Catch:{ Throwable -> 0x01dc }
//            android.view.WindowManager r13 = r12.j     // Catch:{ Throwable -> 0x01dc }
//            ali r2 = r12.m     // Catch:{ Throwable -> 0x01dc }
//            android.view.WindowManager$LayoutParams r5 = r12.o     // Catch:{ Throwable -> 0x01dc }
//            goto L_0x017a
//        L_0x01be:
//            float r13 = r12.y     // Catch:{ Throwable -> 0x01dc }
//            int r5 = r12.C     // Catch:{ Throwable -> 0x01dc }
//            float r5 = (float) r5     // Catch:{ Throwable -> 0x01dc }
//            float r13 = r13 / r5
//            float r13 = r13 * r2
//            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x01dc }
//            java.lang.Float r6 = java.lang.Float.valueOf(r13)     // Catch:{ Throwable -> 0x01dc }
//            r5[r1] = r6     // Catch:{ Throwable -> 0x01dc }
//            int r2 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
//            if (r2 > 0) goto L_0x01e5
//            r12.a((float) r13)     // Catch:{ Throwable -> 0x01dc }
//            android.view.WindowManager r13 = r12.j     // Catch:{ Throwable -> 0x01dc }
//            ali r2 = r12.m     // Catch:{ Throwable -> 0x01dc }
//            android.view.WindowManager$LayoutParams r5 = r12.o     // Catch:{ Throwable -> 0x01dc }
//            goto L_0x017a
//        L_0x01dc:
//            r13 = move-exception
//            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x0539 }
//            java.lang.String r13 = r13.getMessage()     // Catch:{ Throwable -> 0x0539 }
//            r2[r1] = r13     // Catch:{ Throwable -> 0x0539 }
//        L_0x01e5:
//            int r13 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x0539 }
//            r2 = 21
//            if (r13 >= r2) goto L_0x0524
//            if (r14 == 0) goto L_0x0524
//            int r13 = r14.getAction()     // Catch:{ Throwable -> 0x0539 }
//            r2 = 1132396544(0x437f0000, float:255.0)
//            r5 = 0
//            r6 = 1065353216(0x3f800000, float:1.0)
//            switch(r13) {
//                case 0: goto L_0x0510;
//                case 1: goto L_0x0345;
//                case 2: goto L_0x01fb;
//                default: goto L_0x01f9;
//            }     // Catch:{ Throwable -> 0x0539 }
//        L_0x01f9:
//            goto L_0x0524
//        L_0x01fb:
//            float r13 = r14.getRawX()     // Catch:{ Throwable -> 0x0539 }
//            r12.W = r13     // Catch:{ Throwable -> 0x0539 }
//            float r13 = r14.getRawY()     // Catch:{ Throwable -> 0x0539 }
//            r12.X = r13     // Catch:{ Throwable -> 0x0539 }
//            float r13 = r12.Y     // Catch:{ Throwable -> 0x0539 }
//            float r4 = r12.W     // Catch:{ Throwable -> 0x0539 }
//            int r13 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
//            if (r13 >= 0) goto L_0x0213
//            float r13 = r12.W     // Catch:{ Throwable -> 0x0539 }
//            r12.Y = r13     // Catch:{ Throwable -> 0x0539 }
//        L_0x0213:
//            float r13 = r12.aa     // Catch:{ Throwable -> 0x0539 }
//            float r4 = r12.W     // Catch:{ Throwable -> 0x0539 }
//            int r13 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
//            if (r13 <= 0) goto L_0x021f
//            float r13 = r12.W     // Catch:{ Throwable -> 0x0539 }
//            r12.aa = r13     // Catch:{ Throwable -> 0x0539 }
//        L_0x021f:
//            float r13 = r12.Z     // Catch:{ Throwable -> 0x0539 }
//            float r4 = r12.X     // Catch:{ Throwable -> 0x0539 }
//            int r13 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
//            if (r13 >= 0) goto L_0x022b
//            float r13 = r12.X     // Catch:{ Throwable -> 0x0539 }
//            r12.Z = r13     // Catch:{ Throwable -> 0x0539 }
//        L_0x022b:
//            float r13 = r12.ab     // Catch:{ Throwable -> 0x0539 }
//            float r4 = r12.X     // Catch:{ Throwable -> 0x0539 }
//            int r13 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
//            if (r13 <= 0) goto L_0x0237
//            float r13 = r12.X     // Catch:{ Throwable -> 0x0539 }
//            r12.ab = r13     // Catch:{ Throwable -> 0x0539 }
//        L_0x0237:
//            float r13 = r14.getRawX()     // Catch:{ Throwable -> 0x033a }
//            r12.W = r13     // Catch:{ Throwable -> 0x033a }
//            float r13 = r14.getRawY()     // Catch:{ Throwable -> 0x033a }
//            r12.X = r13     // Catch:{ Throwable -> 0x033a }
//            int r13 = r12.u     // Catch:{ Throwable -> 0x033a }
//            switch(r13) {
//                case 0: goto L_0x0304;
//                case 1: goto L_0x02cf;
//                case 2: goto L_0x0296;
//                case 3: goto L_0x024a;
//                default: goto L_0x0248;
//            }     // Catch:{ Throwable -> 0x033a }
//        L_0x0248:
//            goto L_0x0524
//        L_0x024a:
//            int r13 = r12.C     // Catch:{ Throwable -> 0x033a }
//            float r13 = (float) r13     // Catch:{ Throwable -> 0x033a }
//            float r2 = r12.X     // Catch:{ Throwable -> 0x033a }
//            float r13 = r13 - r2
//            int r2 = r12.C     // Catch:{ Throwable -> 0x033a }
//            int r2 = r2 * 2
//            float r2 = (float) r2     // Catch:{ Throwable -> 0x033a }
//            r3 = 1077936128(0x40400000, float:3.0)
//            float r2 = r2 / r3
//            float r13 = r13 / r2
//            r12.ac = r13     // Catch:{ Throwable -> 0x033a }
//            float r13 = r12.ac     // Catch:{ Throwable -> 0x033a }
//            int r13 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
//            if (r13 <= 0) goto L_0x0263
//            r12.ac = r6     // Catch:{ Throwable -> 0x033a }
//        L_0x0263:
//            java.lang.Object[] r13 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x033a }
//            float r2 = r12.ac     // Catch:{ Throwable -> 0x033a }
//            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ Throwable -> 0x033a }
//            r13[r1] = r2     // Catch:{ Throwable -> 0x033a }
//            float r13 = r12.ac     // Catch:{ Throwable -> 0x033a }
//            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
//            if (r13 < 0) goto L_0x0524
//            java.lang.Object[] r13 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x033a }
//            float r2 = r12.ac     // Catch:{ Throwable -> 0x033a }
//            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ Throwable -> 0x033a }
//            r13[r1] = r2     // Catch:{ Throwable -> 0x033a }
//            android.support.v7.widget.AppCompatImageView r13 = r12.n     // Catch:{ Throwable -> 0x033a }
//            if (r13 == 0) goto L_0x0524
//            android.view.WindowManager$LayoutParams r13 = r12.p     // Catch:{ Throwable -> 0x033a }
//            if (r13 == 0) goto L_0x0524
//            android.view.WindowManager$LayoutParams r13 = r12.p     // Catch:{ Throwable -> 0x033a }
//            float r2 = r12.ac     // Catch:{ Throwable -> 0x033a }
//            r13.alpha = r2     // Catch:{ Throwable -> 0x033a }
//            android.view.WindowManager r13 = r12.j     // Catch:{ Throwable -> 0x033a }
//            android.support.v7.widget.AppCompatImageView r2 = r12.n     // Catch:{ Throwable -> 0x033a }
//            android.view.WindowManager$LayoutParams r3 = r12.p     // Catch:{ Throwable -> 0x033a }
//        L_0x0291:
//            r13.updateViewLayout(r2, r3)     // Catch:{ Throwable -> 0x033a }
//            goto L_0x0524
//        L_0x0296:
//            int r13 = r12.B     // Catch:{ Throwable -> 0x033a }
//            float r13 = (float) r13     // Catch:{ Throwable -> 0x033a }
//            float r2 = r12.W     // Catch:{ Throwable -> 0x033a }
//            float r13 = r13 - r2
//            int r2 = r12.B     // Catch:{ Throwable -> 0x033a }
//            float r2 = (float) r2     // Catch:{ Throwable -> 0x033a }
//            float r13 = r13 / r2
//            r12.ac = r13     // Catch:{ Throwable -> 0x033a }
//            float r13 = r12.ac     // Catch:{ Throwable -> 0x033a }
//            int r13 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
//            if (r13 <= 0) goto L_0x02aa
//            r12.ac = r6     // Catch:{ Throwable -> 0x033a }
//        L_0x02aa:
//            float r13 = r12.ac     // Catch:{ Throwable -> 0x033a }
//            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
//            if (r13 < 0) goto L_0x0524
//            java.lang.Object[] r13 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x033a }
//            float r2 = r12.ac     // Catch:{ Throwable -> 0x033a }
//            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ Throwable -> 0x033a }
//            r13[r1] = r2     // Catch:{ Throwable -> 0x033a }
//            android.support.v7.widget.AppCompatImageView r13 = r12.n     // Catch:{ Throwable -> 0x033a }
//            if (r13 == 0) goto L_0x0524
//            android.view.WindowManager$LayoutParams r13 = r12.p     // Catch:{ Throwable -> 0x033a }
//            if (r13 == 0) goto L_0x0524
//            android.view.WindowManager$LayoutParams r13 = r12.p     // Catch:{ Throwable -> 0x033a }
//            float r2 = r12.ac     // Catch:{ Throwable -> 0x033a }
//            r13.alpha = r2     // Catch:{ Throwable -> 0x033a }
//            android.view.WindowManager r13 = r12.j     // Catch:{ Throwable -> 0x033a }
//            android.support.v7.widget.AppCompatImageView r2 = r12.n     // Catch:{ Throwable -> 0x033a }
//            android.view.WindowManager$LayoutParams r3 = r12.p     // Catch:{ Throwable -> 0x033a }
//            goto L_0x0291
//        L_0x02cf:
//            float r13 = r12.W     // Catch:{ Throwable -> 0x033a }
//            int r3 = r12.B     // Catch:{ Throwable -> 0x033a }
//            float r3 = (float) r3     // Catch:{ Throwable -> 0x033a }
//            float r13 = r13 / r3
//            r12.ac = r13     // Catch:{ Throwable -> 0x033a }
//            float r13 = r12.ac     // Catch:{ Throwable -> 0x033a }
//            int r13 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
//            if (r13 <= 0) goto L_0x02df
//            r12.ac = r2     // Catch:{ Throwable -> 0x033a }
//        L_0x02df:
//            float r13 = r12.ac     // Catch:{ Throwable -> 0x033a }
//            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
//            if (r13 < 0) goto L_0x0524
//            java.lang.Object[] r13 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x033a }
//            float r2 = r12.ac     // Catch:{ Throwable -> 0x033a }
//            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ Throwable -> 0x033a }
//            r13[r1] = r2     // Catch:{ Throwable -> 0x033a }
//            android.support.v7.widget.AppCompatImageView r13 = r12.n     // Catch:{ Throwable -> 0x033a }
//            if (r13 == 0) goto L_0x0524
//            android.view.WindowManager$LayoutParams r13 = r12.p     // Catch:{ Throwable -> 0x033a }
//            if (r13 == 0) goto L_0x0524
//            android.view.WindowManager$LayoutParams r13 = r12.p     // Catch:{ Throwable -> 0x033a }
//            float r2 = r12.ac     // Catch:{ Throwable -> 0x033a }
//            r13.alpha = r2     // Catch:{ Throwable -> 0x033a }
//            android.view.WindowManager r13 = r12.j     // Catch:{ Throwable -> 0x033a }
//            android.support.v7.widget.AppCompatImageView r2 = r12.n     // Catch:{ Throwable -> 0x033a }
//            android.view.WindowManager$LayoutParams r3 = r12.p     // Catch:{ Throwable -> 0x033a }
//            goto L_0x0291
//        L_0x0304:
//            float r13 = r12.X     // Catch:{ Throwable -> 0x033a }
//            int r2 = r12.C     // Catch:{ Throwable -> 0x033a }
//            float r2 = (float) r2     // Catch:{ Throwable -> 0x033a }
//            float r13 = r13 / r2
//            r12.ac = r13     // Catch:{ Throwable -> 0x033a }
//            float r13 = r12.ac     // Catch:{ Throwable -> 0x033a }
//            int r13 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
//            if (r13 <= 0) goto L_0x0314
//            r12.ac = r6     // Catch:{ Throwable -> 0x033a }
//        L_0x0314:
//            float r13 = r12.ac     // Catch:{ Throwable -> 0x033a }
//            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
//            if (r13 < 0) goto L_0x0524
//            java.lang.Object[] r13 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x033a }
//            float r2 = r12.ac     // Catch:{ Throwable -> 0x033a }
//            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ Throwable -> 0x033a }
//            r13[r1] = r2     // Catch:{ Throwable -> 0x033a }
//            android.support.v7.widget.AppCompatImageView r13 = r12.n     // Catch:{ Throwable -> 0x033a }
//            if (r13 == 0) goto L_0x0524
//            android.view.WindowManager$LayoutParams r13 = r12.p     // Catch:{ Throwable -> 0x033a }
//            if (r13 == 0) goto L_0x0524
//            android.view.WindowManager$LayoutParams r13 = r12.p     // Catch:{ Throwable -> 0x033a }
//            float r2 = r12.ac     // Catch:{ Throwable -> 0x033a }
//            r13.alpha = r2     // Catch:{ Throwable -> 0x033a }
//            android.view.WindowManager r13 = r12.j     // Catch:{ Throwable -> 0x033a }
//            android.support.v7.widget.AppCompatImageView r2 = r12.n     // Catch:{ Throwable -> 0x033a }
//            android.view.WindowManager$LayoutParams r3 = r12.p     // Catch:{ Throwable -> 0x033a }
//            goto L_0x0291
//        L_0x033a:
//            r13 = move-exception
//            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x0539 }
//            java.lang.String r13 = r13.getMessage()     // Catch:{ Throwable -> 0x0539 }
//            r2[r1] = r13     // Catch:{ Throwable -> 0x0539 }
//            goto L_0x0524
//        L_0x0345:
//            float r13 = r14.getRawX()     // Catch:{ Throwable -> 0x0502 }
//            r12.W = r13     // Catch:{ Throwable -> 0x0502 }
//            float r13 = r14.getRawY()     // Catch:{ Throwable -> 0x0502 }
//            r12.X = r13     // Catch:{ Throwable -> 0x0502 }
//            android.animation.ValueAnimator r13 = new android.animation.ValueAnimator     // Catch:{ Throwable -> 0x0502 }
//            r13.<init>()     // Catch:{ Throwable -> 0x0502 }
//            int r7 = r12.u     // Catch:{ Throwable -> 0x0502 }
//            r8 = 100
//            r9 = 1140457472(0x43fa0000, float:500.0)
//            r10 = 1138819072(0x43e10000, float:450.0)
//            r11 = 1120403456(0x42c80000, float:100.0)
//            switch(r7) {
//                case 0: goto L_0x048f;
//                case 1: goto L_0x042e;
//                case 2: goto L_0x03ce;
//                case 3: goto L_0x0365;
//                default: goto L_0x0363;
//            }     // Catch:{ Throwable -> 0x0502 }
//        L_0x0363:
//            goto L_0x04f6
//        L_0x0365:
//            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Throwable -> 0x0502 }
//            float r7 = r12.aa     // Catch:{ Throwable -> 0x0502 }
//            java.lang.Float r7 = java.lang.Float.valueOf(r7)     // Catch:{ Throwable -> 0x0502 }
//            r4[r1] = r7     // Catch:{ Throwable -> 0x0502 }
//            float r7 = r12.W     // Catch:{ Throwable -> 0x0502 }
//            java.lang.Float r7 = java.lang.Float.valueOf(r7)     // Catch:{ Throwable -> 0x0502 }
//            r4[r0] = r7     // Catch:{ Throwable -> 0x0502 }
//            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)     // Catch:{ Throwable -> 0x0502 }
//            r4[r3] = r7     // Catch:{ Throwable -> 0x0502 }
//            float r4 = r12.X     // Catch:{ Throwable -> 0x0502 }
//            float r7 = r12.ab     // Catch:{ Throwable -> 0x0502 }
//            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
//            if (r4 <= 0) goto L_0x03b0
//            float r4 = r12.X     // Catch:{ Throwable -> 0x0502 }
//            float r7 = r12.ab     // Catch:{ Throwable -> 0x0502 }
//            float r4 = r4 - r7
//            int r4 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
//            if (r4 <= 0) goto L_0x03b0
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
//            if (r4 > 0) goto L_0x04f6
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
//            if (r4 > 0) goto L_0x04f6
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            float r4 = r4 * r2
//            float r9 = r9 - r4
//            long r6 = (long) r9     // Catch:{ Throwable -> 0x0502 }
//            r13.setDuration(r6)     // Catch:{ Throwable -> 0x0502 }
//            float[] r2 = new float[r3]     // Catch:{ Throwable -> 0x0502 }
//            float r3 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            r2[r1] = r3     // Catch:{ Throwable -> 0x0502 }
//            r2[r0] = r5     // Catch:{ Throwable -> 0x0502 }
//        L_0x03ab:
//            r13.setFloatValues(r2)     // Catch:{ Throwable -> 0x0502 }
//            goto L_0x04f6
//        L_0x03b0:
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
//            if (r4 > 0) goto L_0x04f6
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
//            if (r4 > 0) goto L_0x04f6
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            float r4 = r4 * r2
//            float r9 = r9 - r4
//            long r7 = (long) r9     // Catch:{ Throwable -> 0x0502 }
//            r13.setDuration(r7)     // Catch:{ Throwable -> 0x0502 }
//            float[] r2 = new float[r3]     // Catch:{ Throwable -> 0x0502 }
//            float r3 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            r2[r1] = r3     // Catch:{ Throwable -> 0x0502 }
//            r2[r0] = r6     // Catch:{ Throwable -> 0x0502 }
//            goto L_0x03ab
//        L_0x03ce:
//            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Throwable -> 0x0502 }
//            float r7 = r12.aa     // Catch:{ Throwable -> 0x0502 }
//            java.lang.Float r7 = java.lang.Float.valueOf(r7)     // Catch:{ Throwable -> 0x0502 }
//            r4[r1] = r7     // Catch:{ Throwable -> 0x0502 }
//            float r7 = r12.W     // Catch:{ Throwable -> 0x0502 }
//            java.lang.Float r7 = java.lang.Float.valueOf(r7)     // Catch:{ Throwable -> 0x0502 }
//            r4[r0] = r7     // Catch:{ Throwable -> 0x0502 }
//            float r4 = r12.W     // Catch:{ Throwable -> 0x0502 }
//            float r7 = r12.aa     // Catch:{ Throwable -> 0x0502 }
//            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
//            if (r4 <= 0) goto L_0x040f
//            float r4 = r12.W     // Catch:{ Throwable -> 0x0502 }
//            float r7 = r12.aa     // Catch:{ Throwable -> 0x0502 }
//            float r4 = r4 - r7
//            int r4 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
//            if (r4 <= 0) goto L_0x040f
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
//            if (r4 > 0) goto L_0x04f6
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
//            if (r4 > 0) goto L_0x04f6
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            float r4 = r4 * r2
//            float r10 = r10 - r4
//            long r6 = (long) r10     // Catch:{ Throwable -> 0x0502 }
//            r13.setDuration(r6)     // Catch:{ Throwable -> 0x0502 }
//            float[] r2 = new float[r3]     // Catch:{ Throwable -> 0x0502 }
//            float r3 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            r2[r1] = r3     // Catch:{ Throwable -> 0x0502 }
//            r2[r0] = r5     // Catch:{ Throwable -> 0x0502 }
//            goto L_0x03ab
//        L_0x040f:
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
//            if (r4 > 0) goto L_0x04f6
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
//            if (r4 > 0) goto L_0x04f6
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            float r4 = r4 * r2
//            float r10 = r10 - r4
//            long r7 = (long) r10     // Catch:{ Throwable -> 0x0502 }
//            r13.setDuration(r7)     // Catch:{ Throwable -> 0x0502 }
//            float[] r2 = new float[r3]     // Catch:{ Throwable -> 0x0502 }
//            float r3 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            r2[r1] = r3     // Catch:{ Throwable -> 0x0502 }
//            r2[r0] = r6     // Catch:{ Throwable -> 0x0502 }
//            goto L_0x03ab
//        L_0x042e:
//            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Throwable -> 0x0502 }
//            float r7 = r12.aa     // Catch:{ Throwable -> 0x0502 }
//            java.lang.Float r7 = java.lang.Float.valueOf(r7)     // Catch:{ Throwable -> 0x0502 }
//            r4[r1] = r7     // Catch:{ Throwable -> 0x0502 }
//            float r7 = r12.W     // Catch:{ Throwable -> 0x0502 }
//            java.lang.Float r7 = java.lang.Float.valueOf(r7)     // Catch:{ Throwable -> 0x0502 }
//            r4[r0] = r7     // Catch:{ Throwable -> 0x0502 }
//            float r4 = r12.W     // Catch:{ Throwable -> 0x0502 }
//            float r7 = r12.Y     // Catch:{ Throwable -> 0x0502 }
//            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
//            if (r4 >= 0) goto L_0x0470
//            float r4 = r12.Y     // Catch:{ Throwable -> 0x0502 }
//            float r7 = r12.W     // Catch:{ Throwable -> 0x0502 }
//            float r4 = r4 - r7
//            int r4 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
//            if (r4 <= 0) goto L_0x0470
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
//            if (r4 > 0) goto L_0x04f6
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
//            if (r4 > 0) goto L_0x04f6
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            float r4 = r4 * r2
//            float r10 = r10 - r4
//            long r6 = (long) r10     // Catch:{ Throwable -> 0x0502 }
//            r13.setDuration(r6)     // Catch:{ Throwable -> 0x0502 }
//            float[] r2 = new float[r3]     // Catch:{ Throwable -> 0x0502 }
//            float r3 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            r2[r1] = r3     // Catch:{ Throwable -> 0x0502 }
//            r2[r0] = r5     // Catch:{ Throwable -> 0x0502 }
//            goto L_0x03ab
//        L_0x0470:
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
//            if (r4 > 0) goto L_0x04f6
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
//            if (r4 > 0) goto L_0x04f6
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            float r4 = r4 * r2
//            float r10 = r10 - r4
//            long r7 = (long) r10     // Catch:{ Throwable -> 0x0502 }
//            r13.setDuration(r7)     // Catch:{ Throwable -> 0x0502 }
//            float[] r2 = new float[r3]     // Catch:{ Throwable -> 0x0502 }
//            float r3 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            r2[r1] = r3     // Catch:{ Throwable -> 0x0502 }
//            r2[r0] = r6     // Catch:{ Throwable -> 0x0502 }
//            goto L_0x03ab
//        L_0x048f:
//            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Throwable -> 0x0502 }
//            float r7 = r12.Z     // Catch:{ Throwable -> 0x0502 }
//            java.lang.Float r7 = java.lang.Float.valueOf(r7)     // Catch:{ Throwable -> 0x0502 }
//            r4[r1] = r7     // Catch:{ Throwable -> 0x0502 }
//            float r7 = r12.X     // Catch:{ Throwable -> 0x0502 }
//            java.lang.Float r7 = java.lang.Float.valueOf(r7)     // Catch:{ Throwable -> 0x0502 }
//            r4[r0] = r7     // Catch:{ Throwable -> 0x0502 }
//            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)     // Catch:{ Throwable -> 0x0502 }
//            r4[r3] = r7     // Catch:{ Throwable -> 0x0502 }
//            float r4 = r12.X     // Catch:{ Throwable -> 0x0502 }
//            float r7 = r12.Z     // Catch:{ Throwable -> 0x0502 }
//            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
//            if (r4 >= 0) goto L_0x04d7
//            float r4 = r12.Z     // Catch:{ Throwable -> 0x0502 }
//            float r7 = r12.X     // Catch:{ Throwable -> 0x0502 }
//            float r4 = r4 - r7
//            int r4 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
//            if (r4 <= 0) goto L_0x04d7
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
//            if (r4 > 0) goto L_0x04f6
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
//            if (r4 > 0) goto L_0x04f6
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            float r4 = r4 * r2
//            float r9 = r9 - r4
//            long r6 = (long) r9     // Catch:{ Throwable -> 0x0502 }
//            r13.setDuration(r6)     // Catch:{ Throwable -> 0x0502 }
//            float[] r2 = new float[r3]     // Catch:{ Throwable -> 0x0502 }
//            float r3 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            r2[r1] = r3     // Catch:{ Throwable -> 0x0502 }
//            r2[r0] = r5     // Catch:{ Throwable -> 0x0502 }
//            goto L_0x03ab
//        L_0x04d7:
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
//            if (r4 > 0) goto L_0x04f6
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
//            if (r4 > 0) goto L_0x04f6
//            float r4 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            float r4 = r4 * r2
//            float r9 = r9 - r4
//            long r7 = (long) r9     // Catch:{ Throwable -> 0x0502 }
//            r13.setDuration(r7)     // Catch:{ Throwable -> 0x0502 }
//            float[] r2 = new float[r3]     // Catch:{ Throwable -> 0x0502 }
//            float r3 = r12.ac     // Catch:{ Throwable -> 0x0502 }
//            r2[r1] = r3     // Catch:{ Throwable -> 0x0502 }
//            r2[r0] = r6     // Catch:{ Throwable -> 0x0502 }
//            goto L_0x03ab
//        L_0x04f6:
//            com.luutinhit.service.ControlCenterService$2 r2 = new com.luutinhit.service.ControlCenterService$2     // Catch:{ Throwable -> 0x0502 }
//            r2.<init>()     // Catch:{ Throwable -> 0x0502 }
//            r13.addUpdateListener(r2)     // Catch:{ Throwable -> 0x0502 }
//            r13.start()     // Catch:{ Throwable -> 0x0502 }
//            goto L_0x050b
//        L_0x0502:
//            r13 = move-exception
//            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x0539 }
//            java.lang.String r13 = r13.getMessage()     // Catch:{ Throwable -> 0x0539 }
//            r2[r1] = r13     // Catch:{ Throwable -> 0x0539 }
//        L_0x050b:
//            r12.Z = r5     // Catch:{ Throwable -> 0x0539 }
//            r12.Y = r5     // Catch:{ Throwable -> 0x0539 }
//            goto L_0x0524
//        L_0x0510:
//            float r13 = r14.getRawX()     // Catch:{ Throwable -> 0x0539 }
//            r12.W = r13     // Catch:{ Throwable -> 0x0539 }
//            float r13 = r14.getRawY()     // Catch:{ Throwable -> 0x0539 }
//            r12.X = r13     // Catch:{ Throwable -> 0x0539 }
//            float r13 = r12.W     // Catch:{ Throwable -> 0x0539 }
//            r12.aa = r13     // Catch:{ Throwable -> 0x0539 }
//            float r13 = r12.X     // Catch:{ Throwable -> 0x0539 }
//            r12.ab = r13     // Catch:{ Throwable -> 0x0539 }
//        L_0x0524:
//            ali r13 = r12.m     // Catch:{ Throwable -> 0x0539 }
//            if (r13 == 0) goto L_0x0538
//            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0539 }
//            java.lang.String r2 = "onTouch event = "
//            r13.<init>(r2)     // Catch:{ Throwable -> 0x0539 }
//            r13.append(r14)     // Catch:{ Throwable -> 0x0539 }
//            ali r13 = r12.m     // Catch:{ Throwable -> 0x0539 }
//            r2 = 0
//            r13.onTouch(r2, r14)     // Catch:{ Throwable -> 0x0539 }
//        L_0x0538:
//            return r0
//        L_0x0539:
//            r13 = move-exception
//            java.lang.Object[] r14 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x0543 }
//            java.lang.String r13 = r13.getMessage()     // Catch:{ Throwable -> 0x0543 }
//            r14[r1] = r13     // Catch:{ Throwable -> 0x0543 }
//        L_0x0542:
//            return r1
//        L_0x0543:
//            r13 = move-exception
//            java.lang.Object[] r14 = new java.lang.Object[r0]
//            java.lang.String r13 = r13.getMessage()
//            r14[r1] = r13
//            return r1
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.service.ControlCenterService.onTouch(android.view.View, android.view.MotionEvent):boolean");
//    }
//
//    public void onTrimMemory(int i2) {
//        r();
//    }
//}
