package com.example.appmovies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.appmovies.databinding.ActivityMainBinding
import com.example.appmovies.models.Movie
import com.example.appmovies.models.MovieDBClient
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val moviesAdapter = MoviesAdapter( emptyList()) { navigateTo(it)
//            Toast.makeText(this, movie.title, Toast.LENGTH_SHORT).show()
        }

        binding.recyclerMovies.adapter = moviesAdapter

        lifecycleScope.launch {
            val apiKey = getString(R.string.apikey)
            val popularMovies = MovieDBClient.service.listPopularMovies(apiKey)
            moviesAdapter.movies = popularMovies.results
            moviesAdapter.notifyDataSetChanged()
        }

    }

    private fun navigateTo(movie : Movie) {
        val detailIntent = Intent(this, DetailActivity::class.java)
        detailIntent.putExtra(DetailActivity.EXTRA_MOVIE, movie)
        startActivity(detailIntent)
    }
}