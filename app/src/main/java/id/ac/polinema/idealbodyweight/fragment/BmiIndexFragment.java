package id.ac.polinema.idealbodyweight.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import id.ac.polinema.idealbodyweight.R;
import id.ac.polinema.idealbodyweight.util.BmiIndex;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BmiIndexFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BmiIndexFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public BmiIndexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bmi_index, container, false);
        final EditText heightText = view.findViewById(R.id.text_height);
        final EditText massText = view.findViewById(R.id.text_mass);

        Button calButton = view.findViewById(R.id.button_submit);
        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    String tmpHeight = heightText.getText().toString();
                    String tmpMass = massText.getText().toString();
                    int mass = Integer.parseInt(tmpMass);
                    int height = Integer.parseInt(tmpHeight);
                    BmiIndex bmiIndex = new BmiIndex(mass, height);
                    mListener.onCalculateBmiIndexClicked(bmiIndex.getResult());
                }
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onCalculateBmiIndexClicked(String index);
    }
}
