package com.example.myshopapimirzhan.ui.backet;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.myshopapimirzhan.R;
import com.example.myshopapimirzhan.databinding.FragmentDashboardBinding;
import com.example.myshopapimirzhan.models.ModelM;
import com.example.myshopapimirzhan.ui.home.JemAdapter;

import java.util.ArrayList;

public class BacketFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private ArrayList<ModelM> basket_products;
    JemAdapter adapter;
    NavController navController;
    Double total_sum = 0.0;
//    LottieAnimationView lotty_buying;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BacketViewModel dashboardViewModel =
                new ViewModelProvider(this).get(BacketViewModel.class);


        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
//        lotty_buying=binding.lottyBuying;
//        lotty_buying.setAnimation(R.raw.lottybuying);
        if (getArguments() != null) {
            basket_products = new ArrayList<>();
            basket_products = getArguments().getParcelableArrayList("keysss_basket");
        }
        if (basket_products != null) {
            binding.placeHolder.setVisibility(View.GONE);
            adapter = new JemAdapter(requireActivity(), basket_products);
            binding.rvBasket.setAdapter(adapter);
        } else {
            binding.placeHolder.setVisibility(View.VISIBLE);
        }

        try {
            for (int i = 0; i <basket_products.size(); i++) {
                total_sum += basket_products.get(i).getModelPrice();
            }
            binding.basketTotalCount.setText(String.valueOf(total_sum));
            binding.placeHolder.setVisibility(View.VISIBLE);

        } catch (NullPointerException ex) {
            binding.basketTotalCount.setText("0.00");
            binding.placeHolder.setVisibility(View.VISIBLE);
            Log.e("TAG", "error" + ex.getLocalizedMessage());
        }

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnBack.setOnClickListener(v -> {
            navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
            navController.navigate(R.id.action_navigation_dashboard_to_navigation_home);
        });

        binding.btnPay.setOnClickListener(v1 -> {
            navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
            navController.navigate(R.id.navigation_payment);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}