package com.example.appmovies.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.widget.TextView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.bumptech.glide.Glide
import com.example.appmovies.R
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
            appendInfo(R.string.original_language , movie.original_language)
            appendInfo(R.string.original_title , movie.original_title)
            appendInfo(R.string.release_date , movie.release_date)
            appendInfo(R.string.popularity , movie.popularity.toString())
            appendInfo(R.string.vote_average , movie.vote_average.toString())

            /*bold { append(" Original Language: ") }
            appendLine(movie.original_language)

            bold { append(" Original Title: ") }
            appendLine(movie.original_title)

            bold { append(" Release Date: ") }
            appendLine(movie.release_date)

            bold { append(" Popularity: ") }
            appendLine(movie.popularity.toString())

            bold { append(" Vote average: ") }
            appendLine(movie.vote_average.toString())*/
        }
    }

//Con funcion de extensión
    private fun SpannableStringBuilder.appendInfo(stringRes : Int, value : String){
        bold {
            append( getString( stringRes))
            append(" : ")
        }
        appendLine(value)
    }

//Sin funcion de extensión
/*    private fun appendInfo( builder: SpannableStringBuilder, stringRes : Int, value : String){
        builder.bold {
            getString(stringRes)
            append(" : ")
        }
        builder.appendLine(value)
    }*/


}