package id.ac.polinema.idealbodyweight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import id.ac.polinema.idealbodyweight.fragment.AboutFragment;
import id.ac.polinema.idealbodyweight.fragment.BmiIndexFragment;
import id.ac.polinema.idealbodyweight.fragment.BrocaIndexFragment;
import id.ac.polinema.idealbodyweight.fragment.MenuFragment;
import id.ac.polinema.idealbodyweight.fragment.ResultFragment;
import id.ac.polinema.idealbodyweight.util.BrocaIndex;

public class MainActivity extends AppCompatActivity implements MenuFragment.OnFragmentInteractionListener,BrocaIndexFragment.OnFragmentInteractionListener, ResultFragment.OnFragmentInteractionListener,
		BmiIndexFragment.OnFragmentInteractionListener {

	private AboutFragment aboutFragment;
	private MenuFragment menuFragment;
	private BrocaIndexFragment brocaIndexFragment;
	private ResultFragment resultFragment;
	private BmiIndexFragment bmiIndexFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		aboutFragment = AboutFragment.newInstance("Mohammad Fauzan Arramadhan");
		menuFragment = new MenuFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, menuFragment)
				.commit();
		brocaIndexFragment = new BrocaIndexFragment();
		bmiIndexFragment = new BmiIndexFragment();
		resultFragment = new ResultFragment();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return  true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		if (item.getItemId() == R.id.menu_about){
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, aboutFragment)
					.addToBackStack(null)
					.commit();
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBrocaIndexButtonClicked() {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, brocaIndexFragment)
				.commit();
	}

	@Override
	public void onBodyMassIndexButtonClicked() {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, bmiIndexFragment)
				.commit();
	}

	@Override
	public void onCalculateBrocaIndexClicked(float index) {
        resultFragment.setInformation(String.format("Your ideal weight is %.2f kg", index));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, resultFragment)
                .commit();
	}

    @Override
    public void onTryAgainButtonClicked(String tag) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, brocaIndexFragment)
                .commit();
    }

	@Override
	public void onCalculateBmiIndexClicked(String index) {
		resultFragment.setInformation(index);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, resultFragment)
				.commit();
	}
}
