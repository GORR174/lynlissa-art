package ru.catstack.lynlissaart.data.api.deviantart

import okhttp3.ResponseBody
import org.jsoup.Jsoup
import org.w3c.dom.Element
import retrofit2.Converter
import retrofit2.Retrofit
import ru.catstack.lynlissaart.domain.Art
import ru.catstack.lynlissaart.domain.DeviantResponse
import java.lang.reflect.Type
import javax.xml.parsers.DocumentBuilderFactory

class DeviantResponseConverterFactory : Converter.Factory() {
    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, DeviantResponse>? {
        return if (type == DeviantResponse::class.java) DeviantResponseConverter else null
    }

    private object DeviantResponseConverter : Converter<ResponseBody, DeviantResponse> {
        override fun convert(value: ResponseBody): DeviantResponse? {
            val text = value.string()
            val response = DeviantResponse(ArrayList())
            val builder = DocumentBuilderFactory.newInstance().newDocumentBuilder()

            val doc = builder.parse(text.byteInputStream())
            val items = doc.getElementsByTagName("item")

            for (i in 0 until items.length) {
                val item = items.item(i) as Element

                val currentArt = getArtByItemElement(item)

                response.arts.add(currentArt)
            }

            return response
        }

        private fun getArtByItemElement(item: Element): Art {
            val title = getTitleByItemElement(item)
            val url = getUrlByItem(item)
            val description = getDescriptionByItem(item)

            return Art(title, url, description)
        }

        private fun getTitleByItemElement(item: Element): String {
            val titleElement = item.getElementsByTagName("title").item(0) as Element

            return titleElement.textContent
        }

        private fun getUrlByItem(item: Element): String {
            val urlElement = item.getElementsByTagName("media:content").item(0) as Element

            return urlElement.getAttribute("url")
        }

        private fun getDescriptionByItem(item: Element): String {
            val descriptionElement = item.getElementsByTagName("media:description").item(0) as Element
            val text = descriptionElement.textContent

            return Jsoup.parse(text).text()
        }
    }
}