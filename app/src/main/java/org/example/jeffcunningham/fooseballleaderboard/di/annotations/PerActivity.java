package org.example.jeffcunningham.fooseballleaderboard.di.annotations;

/**
 * Created by jeffcunningham on 1/22/17.
 */

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the activity to be memoized in the
 * correct component.
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {

}