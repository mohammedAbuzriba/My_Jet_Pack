
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ly.umbrella.roomapplications.data.repository.ApiPostRepository
import ly.youcan.myapplication.core.Recourc
import ly.youcan.myapplication.data.ServerApi.PostApi
import ly.youcan.myapplication.data.ServerApi.RetrofitInstance.retrofit
import ly.youcan.myapplication.data.ServerApi.model.Post
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiPostRepositoryImp : ApiPostRepository {
    override suspend fun getAllposts(): Flow<Recourc<Post>> {


        return flow {
            emit(Recourc.Loading<Post>())
            var response = retrofit.getAllpost()
            if (response.isSuccessful){
                if (response.body()==null){
                    emit(Recourc.Error<Post>("No data !!"))
                }
                emit(Recourc.Success<Post>(data=response.body()))
            }else{
                emit(Recourc.Error<Post>(response.message()))
            }

        }
    }

}