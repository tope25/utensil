package kitchen.app.utensilwizard.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import kitchen.app.utensilwizard.databinding.UtensilViewBinding
import kitchen.app.utensilwizard.utensils.UtensilContent

class UtensilAdapter(private val context: Context,
                     private val utensilList: List<UtensilModels>,) :
    PagerAdapter() {
    override fun getCount(): Int {
        return utensilList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = UtensilViewBinding.inflate(LayoutInflater.from(context), container, false)
        val view = binding.root

        val models = utensilList[position]
        val imageUtensils = models.utensilPic
        val nameUtensils = models.utensilId
        val aboutUtensils = context.resources.getStringArray(models.utensilMean)

        val utensilContents = aboutUtensils.joinToString("\n\n")
        binding.imageView.setImageResource(imageUtensils)
        binding.titleText.text = nameUtensils
        binding.contentText.text = utensilContents

        view.setOnClickListener {
            val intent = Intent(context, UtensilContent::class.java)
            intent.putExtra("image", imageUtensils)
            intent.putExtra("content", aboutUtensils)
            context.startActivity(intent)
        }
        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}