package com.example.appmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.bumptech.glide.Glide
import com.example.appmovies.databinding.ActivityDetailBinding
import com.example.appmovies.models.Movie

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "DetailActivity:movie"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)

        if (movie != null) {
            title = movie.title
            Glide
                .with(this)
                .load("https://image.tmdb.org/t/p/w780${movie.backdrop_path}")
                .into(binding.IVBackdrop)
            binding.summary.text = movie.overview
            bindDetailInfo(binding.detailInfo, movie)
        }
    }

    private fun bindDetailInfo(detailInfo: TextView, movie: Movie) {
        detailInfo.text = buildSpannedString {
            bold { append(" Original Language: ") }
            appendLine(movie.original_language)

            bold { append(" Original Title: ") }
            appendLine(movie.original_title)

            bold { append(" Release Date: ") }
            appendLine(movie.release_date)

            bold { append(" Popularity: ") }
            appendLine(movie.popularity.toString())

            bold { append(" Vote average: ") }
            appendLine(movie.vote_average.toString())

        }
    }
}