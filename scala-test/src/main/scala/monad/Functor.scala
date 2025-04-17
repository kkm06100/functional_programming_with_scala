package monad

trait Functor[F[_]] {

  def lift[A, B](f: A => B): F[A] => F[B]

  def map[A, B](fa: F[A])(f: A => B): F[B]

  def liftE1[T, U, V](f: (T, U) => V): (F[T], U) => F[V] = {
    (ft: F[T], u: U) =>
      val f_u: T => V = (t: T) => f(t, u)
      lift(f_u)(ft)
  }

  def liftE2[T, U, V](f:(T, U) => V): (T, F[U]) => F[V] = {
    (t: T, fu: F[U]) =>
      val f_t: U => V = (u: U) => f(t, u)
    lift(f_t)(fu)
   }

  def lift2d[T, U, V](f:(T, U) => V): (F[T], F[U]) => F[F[V]] = {
    (ft: F[T], fu: F[U]) => {
      val f_u: T => F[V] = (t: T) => {
        val f_t: U => V = (u: U) => {
          f(t, u)
        }
        lift(f_t)(fu)
      }
      lift(f_u)(ft)
    }
  }

  def lift2dUpgrade[T, U, V] (f: (T, U) => V): (F[T], F[U]) => F[F[V]] = {
    (ft: F[T], fu: F[U]) => {
      lift((t: T) => {
        lift((u: U) => {
          f(t, u)
        })(fu)
      })(ft  )
    }
  }

  def lift2dUpgradePlus[T, U, V] (f: (T, U) => V): (F[T], F[U]) => F[F[V]] = {
    (ft: F[T], fu: F[U]) => lift((t: T) => lift((u: U) => f(t, u))(fu))(ft)
  }

  def lift3d[T, U, V, W] (f: (T, U, V) => W): (F[T], F[U], F[V]) => F[F[F[W]]] = {
    (ft: F[T], fu: F[U], fv: F[V]) => {
      val g: T => F[F[W]] = (t: T) => {
        val h: U => F[W] = (u: U) => {
          val i:V => W = (v: V) => {
            f(t, u, v)
          }
          lift(i)(fv)
        }
        lift(h)(fu)
      }
      lift(g)(ft)
    }
  }
}
