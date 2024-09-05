package com.project.mytemplate.di

import android.app.Application
import androidx.room.Room
import com.project.mytemplate.data.datasource.FirebaseFirebaseAuthDataSourceImpl
import com.project.mytemplate.data.datasource.LoginDataSourceImpl
import com.project.mytemplate.data.datasource.PostsDataSourceImpl
import com.project.mytemplate.data.interfaces.FirebaseAuthDataSource
import com.project.mytemplate.data.datasource.TaskLocalDataSourceImpl
import com.project.mytemplate.data.datasource.TokenDataSourceImpl
import com.project.mytemplate.data.network.AppDataBase
import com.project.mytemplate.data.interfaces.dao.TaskDao
import com.project.mytemplate.data.interfaces.LoginDataSource
import com.project.mytemplate.data.interfaces.PostsDataSource
import com.project.mytemplate.data.interfaces.TaskLocalDataSource
import com.project.mytemplate.data.repository.FirebaseFirebaseAuthRepositoryImpl
import com.project.mytemplate.data.repository.LoginRepositoryImpl
import com.project.mytemplate.data.repository.PostsRepositoryImpl
import com.project.mytemplate.data.repository.TaskRepositoryImpl
import com.project.mytemplate.data.repository.TokenRepositoryImpl
import com.project.mytemplate.domine.interfaces.FirebaseAuthRepository
import com.project.mytemplate.domine.interfaces.LoginRepository
import com.project.mytemplate.domine.interfaces.PostsRepository
import com.project.mytemplate.domine.interfaces.TaskRepository
import com.project.mytemplate.domine.usecase.AddTaskUseCase
import com.project.mytemplate.domine.usecase.ChangeTaskStateUseCase
import com.project.mytemplate.domine.usecase.LoginUseCase
import com.project.mytemplate.domine.usecase.GetPostsUseCase
import com.project.mytemplate.domine.usecase.GetTasksUseCase
import com.project.mytemplate.domine.usecase.RemoveTaskUseCase
import com.project.mytemplate.domine.usecase.firebase.SignInWithEmailUseCase
import com.project.mytemplate.domine.usecase.firebase.SignInWithGoogleUseCase
import com.project.mytemplate.domine.usecase.firebase.SignUpWithEmailUseCase
import com.project.mytemplate.presentation.screens.login.AuthViewModel
import org.koin.dsl.module
import com.project.mytemplate.presentation.screens.screen1.ScreenOneViewModel
import com.project.mytemplate.presentation.screens.screen2.ScreenTwoViewModel
import com.project.mytemplate.presentation.screens.screen3.ScreenThreeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

val useCaseModule = module {

    single<PostsDataSource> { PostsDataSourceImpl() }
    single<PostsRepository> { PostsRepositoryImpl(get()) }
    factory { GetPostsUseCase(get()) }

    single<LoginDataSource> { LoginDataSourceImpl() }
    single<LoginRepository> { LoginRepositoryImpl(get()) }
    factory { LoginUseCase(get()) }

    single{ TokenDataSourceImpl(get()) }
    single { TokenRepositoryImpl(get()) }

}

val viewModelModule = module {
    viewModel { AuthViewModel(get(), get(), get()) }
    viewModel { ScreenOneViewModel(get()) }
    viewModel { ScreenTwoViewModel(get()) }
    viewModel { ScreenThreeViewModel( get(), get(), get(), get() ) }
}

val firebaseModule = module {
    single<FirebaseAuthDataSource> { FirebaseFirebaseAuthDataSourceImpl() }
    single<FirebaseAuthRepository> { FirebaseFirebaseAuthRepositoryImpl(get()) }
    factory { SignInWithEmailUseCase(get()) }
    factory { SignUpWithEmailUseCase(get()) }
    factory { SignInWithGoogleUseCase(get()) }
}

val roomModule = module {

    single {
        Room.databaseBuilder(
            get(),
            AppDataBase::class.java,
            "TaskEntity"
        ).build()
    }
    single { get<AppDataBase>().taskDao() }

    single<TaskLocalDataSource> { TaskLocalDataSourceImpl(get()) }
    single<TaskRepository> { TaskRepositoryImpl(get()) }
    factory { GetTasksUseCase(get()) }
    factory { AddTaskUseCase(get()) }
    factory { RemoveTaskUseCase(get()) }
    factory { ChangeTaskStateUseCase(get()) }

    // Proveedor de ViewModel

}
