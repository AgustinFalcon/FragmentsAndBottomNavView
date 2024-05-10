package com.example.fragmentsandbottomnavview.fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmentsandbottomnavview.Gym
import com.example.fragmentsandbottomnavview.HomeActivity
import com.example.fragmentsandbottomnavview.R
import com.example.fragmentsandbottomnavview.databinding.FragmentLoginBinding
import com.example.fragmentsandbottomnavview.databinding.FragmentRegisterBinding
import com.google.gson.Gson


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)



        binding.btnRegister.setOnClickListener {
            val user = binding.etUser.text.toString()
            val password = binding.etPass.text.toString().toInt()
            val gym = Gym(user, password)


            val preferences = requireActivity().getSharedPreferences(CREDENTIALS, AppCompatActivity.MODE_PRIVATE)

            val edit = preferences.edit()


            val gson = Gson()
            val gymInJsonFormat = gson.toJson(gym)

            edit.putString("gym", gymInJsonFormat)
            edit.apply()


            Toast.makeText(requireContext(), "Insert realizado!", Toast.LENGTH_SHORT).show()


            val intent = Intent(requireContext(), HomeActivity::class.java)
            startActivity(intent)

        }





        return binding.root
    }


    companion object {
        const val CREDENTIALS = "Credenciales"
    }


}