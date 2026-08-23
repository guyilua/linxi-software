package com.rtk.app.main.UpModule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SecondFragment extends Fragment {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NavHostFragment.findNavController(SecondFragment.this).navigate(R.id.action_SecondFragment_to_FirstFragment);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_second, viewGroup, false);
    }

    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.findViewById(R.id.button_second).setOnClickListener(new a());
    }
}
