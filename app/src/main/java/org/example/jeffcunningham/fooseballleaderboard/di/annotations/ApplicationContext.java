package org.example.jeffcunningham.fooseballleaderboard.di.annotations;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Qualifier annotation to use with dagger dependency injection.
 * Helps resolve conflicts between application {@link android.content.Context} and
 * {@link android.app.Activity} which is also {@link android.content.Context context}
 * and usually passed as a such and not as activity.
 *
 *
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationContext { }