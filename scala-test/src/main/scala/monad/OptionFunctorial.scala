package monad

class OptionFunctorial extends Functor[Option] {

  def lift[A, B](f: A => B): Option[A] => Option[B] = (opt: Option[A]) => map(opt)(f)

  override def map[A, B](fa: Option[A])(f: A => B): _root_.scala.Option[B] = fa.map(f)
}
